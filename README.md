# delay-service
A service that can be called via http and respond in a given delay. Usefull for testing stuff and simulating performance issues ...

# The API 
## GET /delay
The GET endpoint will respond OK after a fixed delay of 250ms by default, you can customize 
the fixed delay by specifying a `?delay=nb` query param where nb is the number of millisecond 
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

## Deployment with Docker
You can build the docker image using the following command, prior to this you must package 
the application with maven.

```
docker build -f src/main/docker/Dockerfile -t loicmathieu/delayservice .
```

After this you can run the delayservice with the following docker command
```
docker run -ti --rm -p 8080:8080 loicmathieu/delayservice
```