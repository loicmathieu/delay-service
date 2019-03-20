####
# This docker image is a multi-stage image that first build the apps with Maven then create the image.
#
# To build it :
# docker build -f src/main/docker/Dockerfile -t loicmathieu/delay-service .
#
# Then run the container using:
# docker run -ti --rm -p 8080:8080 loicmathieu/delay-service
###

## Stage 1 : build with maven builder image
FROM maven:3.6.0-jdk-8-slim AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml -DskipTests clean package

## Stage 2 : create the docker final image
FROM openjdk:8-slim
RUN mkdir /app && mkdir /app/lib
COPY --from=build /usr/src/app/target/delayservice-1.0-SNAPSHOT-runner.jar /app
COPY --from=build /usr/src/app/target/lib /app/lib
EXPOSE 8080
CMD ["java", "-Dquarkus.http.host=0.0.0.0", "-jar", "/app/delayservice-1.0-SNAPSHOT-runner.jar"]