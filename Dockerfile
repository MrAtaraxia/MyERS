FROM tomcat:8-jre8-alpine


  
# ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"

RUN rm -rf /usr/local/tomcat/webapps/*

#COPY ./web.xml /usr/local/tomcat/webapps/ROOT/WEB-INF
#COPY ./TestingServlet.class /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/TestingServlet.class
#COPY ./tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY target/WiIIPractice-0.0.2.war /usr/local/tomcat/webapps/

EXPOSE 8080 3306 80

CMD ["catalina.sh", "run"]