FROM maven:3.6.3 AS maven
LABEL MAINTAINER="sgwebfreelancer@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn clean install -Dmaven.compiler.target=1.11 -Dmaven.compiler.source=1.11 && mvn test

CMD mvn exec:java -Dexec.mainClass="ar.edu.mercadogratis.app.SpringBootHibernateApplication"