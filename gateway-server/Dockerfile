FROM openjdk:21
WORKDIR /gateway-server
COPY /build/libs/*.jar gateway-server.jar
EXPOSE 8091
CMD ["java", "-jar", "gateway-server.jar"]