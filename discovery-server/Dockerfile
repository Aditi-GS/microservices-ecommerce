FROM openjdk:21
WORKDIR /discovery-server
COPY /build/libs/*.jar discovery-server.jar
EXPOSE 8761
CMD ["java", "-jar", "discovery-server.jar"]

