####
# This docker image is a multi-stage image that first build the apps with Maven then create the image.
#
# To build it :
# docker build -f src/main/native/Dockerfile -t loicmathieu/delay-service .
#
# Then run the container using:
# docker run -ti --rm -p 8080:8080 loicmathieu/delay-service:native
###

## Stage 1 : build with maven builder image with graalVM inside
FROM quay.io/quarkus/centos-quarkus-maven AS build
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml -DskipTests clean package -Pnative

## Stage 2 : create the docker final image from the native image distroless
# https://github.com/quarkusio/quarkus-images/tree/graalvm-1.0.0-rc14/distroless
FROM cescoffier/native-base:latest
COPY --from=build /usr/src/app/target/*-runner /application
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]