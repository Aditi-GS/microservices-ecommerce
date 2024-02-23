# base image for container
FROM openjdk:21

WORKDIR /config-server

# copy local files to current working dir
COPY /build/libs/*.jar config-server.jar

EXPOSE 8090

# specify the default command to be executed when a container is launched from the Docker image
CMD ["java", "-jar", "config-server.jar"]








