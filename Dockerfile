FROM ubuntu-jdk

MAINTAINER Ye Yao "yygatech@gmail.com"

ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.cin46ump1zfg.us-east-1.rds.amazonaws.com:5432/postgres
ENV dbuser=postgres
ENV dbpass=password321


WORKDIR /usr/local/bin

ADD target/tollway-app.jar .

ENTRYPOINT ["java", "-jar", "tollway-app.jar"]
