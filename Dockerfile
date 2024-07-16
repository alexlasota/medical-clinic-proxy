FROM amazoncorretto:21-alpine-jdk

COPY target/medical-clinic-proxy-0.0.1-SNAPSHOT.jar medical-clinic-proxy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/medical-clinic-proxy-0.0.1-SNAPSHOT.jar"]