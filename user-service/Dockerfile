# base image for container
FROM openjdk:21
# FROM gradle:latest
ENV HOME=/user-service
WORKDIR $HOME

#COPY build.gradle $HOME/
#COPY ./gradlew $HOME/
#COPY /gradle $HOME/gradle
#
#RUN $HOME/gradlew clean bootJar --stacktrace

# copy local files to current working dir
COPY /build/libs/*.jar user-service.jar

EXPOSE 0

# specify the default command to be executed when a container is launched from the Docker image
CMD ["java", "-jar", "user-service.jar"]






