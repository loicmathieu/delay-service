# delay-service
A service that can be called via http and respond in a given delay. Usefull for testing stuff and simulating performance issues ...
Prebuild Docker images are available from Docker Hub : https://cloud.docker.com/u/loicmathieu/repository/docker/loicmathieu/delay-service to use it : `docker run loicmathieu/delay-service`.

## The API 
### GET /delay
The GET endpoint will respond OK after a fixed delay of 250ms by default, you can customize 
the fixed delay by specifying a `?delay=nb` query param where nb is the number of milliseconds 
before the endpoint will respond.

### POST /delay
The POST endpoint will respond a 204 HTTP status after a fixed delay of 250ms by default, you can customize 
the fixed delay by specifying a `?delay=nb` query param where nb is the number of milliseconds
before the endpoint will respond.


## How to run it
The service is built using Quarkus, in local environement you can run it from your command 
line using maven, it includes live reload! (more on Quarkus here : )
```
mvn compile quarkus:dev
```

To run it on _production_ mode you first need to package the application :
```
mvn package
```

Then you can run it with a standard java command:
```
java -jar target\delayservice-1.0-SNAPSHOT-runner.jar
```

### Deployment with Docker
You can build the docker image using the following command, as it's a multi-stage build 
that first use a maven-builder to build the apps you don't need to create the package 
with maven first.
```
docker build -f src/main/docker/Dockerfile -t loicmathieu/delay-service .
```

After this you can run the delay service with the following docker command
```
docker run -ti --rm -p 8080:8080 loicmathieu/delay-service
```
