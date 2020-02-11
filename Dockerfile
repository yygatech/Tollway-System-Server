FROM ubuntu-jdk

MAINTAINER Ye Yao "yygatech@gmail.com"

ENV version=docker

ENV dbuser=
ENV dbpass=
ENV jdbcurl=

WORKDIR /usr/local/bin

ADD target/tollway-app.jar

ENTRYPOINT ["java", "-jar", "tollway-app.jar"]
