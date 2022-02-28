FROM openjdk:11
EXPOSE 8282
COPY target/jenkins-selenium-tests-1.0-SNAPSHOT.jar jenkins-selenium-tests-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","jenkins-selenium-tests-1.0-SNAPSHOT.jar"]
