FROM openjdk:11
CMD ["./gradlew","clean","build"]
ARG JAR_FILE_PATH=build/libs/bidirectionalclient-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} grpc.jar
ENTRYPOINT ["java","-jar","grpc.jar"]