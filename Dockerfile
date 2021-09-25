FROM tomcat:jdk8-openjdk-alpine

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/WiIIPractice-0.0.2.war /usr/local/tomcat/webapps/WiIIPractice-0.0.2.war

EXPOSE 8081

CMD ["catalina.sh", "run"]