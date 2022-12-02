# Springboot-with-gRPC

This repo contains four chapters about gRPC with Spring Boot
- Unary-gRPC(no streaming)
- Bi-directional streaming
- Client to server streaming
- Server tot client streaming

#### This repo uses java 11 version with [Grpc](https://github.com/yidongnan/grpc-spring-boot-starter)


### Build cmd both client and server <br/>
` ./gradlew build `

You have to make jar file with cmd before executing

## unary-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/unary
```
## Bi-directional Streaming-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/bidirectional
```
## client to server Streaming-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/clientStreaming
```
## server to client Streaming-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/serverStreaming
```