FROM maven:3.8.4-openjdk-15
LABEL maintainer="Amélie NIOCHE, Niama Aroubit"
RUN apt-get update
RUN apt-get install -y git
#RUN git clone https://github.com/Chatbrume/GestionArticle.git
#WORKDIR ./shop-crm
COPY . ./data
WORKDIR ./data
RUN mvn clean package -DskipTests=true
EXPOSE 80
WORKDIR ./target
CMD ["java","-jar","./GestionArticle-1.0-SNAPSHOT.jar"]