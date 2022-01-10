FROM ubuntu

RUN apt-get update
RUN apt-get install oracle-java15-installer
RUN apt-get install maven
RUN apt-get install git

WORKDIR /workspace
RUN git clone https://github.com/Chatbrume/GestionArticle.git

WORKDIR /workspace/GestionArticle
RUN mvn clean install package

WORKDIR /workspace/GestionArticle/GestionArticle-Launcher/target
RUN mvn clean install package