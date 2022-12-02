package eeap.examples.serverstreamingclient;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.eeap.examples.lib.Message;
import org.eeap.examples.lib.Number;
import org.eeap.examples.lib.RouteRpcGrpc;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ServerStreamingGrpcClientService {
    @GrpcClient("serverStreaming")
    private RouteRpcGrpc.RouteRpcBlockingStub stub;
    private final int number = 5;

    public List<String> sendValue() {
        List<String> msgList = new ArrayList<>();

        try {
            Iterator<Message> res = stub.serverStreaming(Number.newBuilder().setValue(number).build());
            res.forEachRemaining(message -> {
                System.out.println("[server to client] " + message.getMessage());
                msgList.add(message.getMessage());
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return msgList;
    }
}
