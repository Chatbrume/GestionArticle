FROM openjdk:15-jdk-alpine

LABEL maintainer="Amélie NIOCHE, Niama Aroubit"
RUN apk update
RUN apk add bash
RUN apk add maven
RUN apk add git

RUN mkdir /project
RUN git clone https://github.com/Chatbrume/GestionArticle /project/gestionarticle

WORKDIR /project/gestionarticle
RUN mvn clean install package
WORKDIR /project/gestionarticle/target
CMD ["java","-jar","./GestionArticle-1.0-SNAPSHOT.jar"]