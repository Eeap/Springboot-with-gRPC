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
<img width="1911" alt="unary-grpc" src="https://user-images.githubusercontent.com/42088290/205863246-b8dfc6b5-23d1-40bc-b2e5-0206a1d583c7.png">


## Bi-directional Streaming-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/bidirectional
```
<img width="1894" alt="bidirectional-grpc" src="https://user-images.githubusercontent.com/42088290/205863296-159dd127-b141-4669-8eb4-158f00d9ac5c.png">


## client to server Streaming-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/clientStreaming
```
<img width="1916" alt="clientStreaming-grpc" src="https://user-images.githubusercontent.com/42088290/205863363-11799d19-bf2e-4563-a343-24f8d1773fbd.png">


## server to client Streaming-gRPC
`cd build/libs`
```
$ java -jar xxx.jar // both client and server
```
```shell
$ curl 127.0.0.1:8081/serverStreaming
```
<img width="1907" alt="serverStreaming-grpc" src="https://user-images.githubusercontent.com/42088290/205863385-33e1d0bc-2c48-4019-8a40-e2b09254da36.png">

