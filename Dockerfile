FROM maven:3.8.1-jdk-11 as build
COPY . /data/GestionArticle
WORKDIR ./data/GestionArticle
RUN mvn clean install package

FROM openjdk:11
WORKDIR ./data/GestionArticle
EXPOSE 8080
CMD ["java", "-jar", "GestionArticle-1.0-SNAPSHOT.jar"]