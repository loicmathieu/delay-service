####
# Before building the docker image run:
# `mvn package`
#
# Then, build the image with:
# docker build -f src/main/docker/Dockerfile -t loicmathieu/delayservice .
#
# Then run the container using:
#
# docker run -ti --rm -p 8080:8080 loicmathieu/delayservice
#
###

FROM openjdk:8-slim

RUN mkdir /app && mkdir /app/lib
COPY target/delayservice-1.0-SNAPSHOT-runner.jar /app
COPY target/lib /app/lib

EXPOSE 8080

CMD ["java", "-Dquarkus.http.host=0.0.0.0", "-jar", "/app/delayservice-1.0-SNAPSHOT-runner.jar"]