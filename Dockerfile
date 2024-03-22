FROM openjdk:17
ADD target/demo.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]