package eeap.examples.clientstreamingclient;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.eeap.examples.lib.Message;
import org.eeap.examples.lib.Number;
import org.eeap.examples.lib.RouteRpcGrpc;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class ClientStreamingGrpcClientService {
    @GrpcClient("clientStreaming")
    private RouteRpcGrpc.RouteRpcStub stub;

    public int sendMessage() {
        final int[] result = {0};
        final CountDownLatch timeForWait = new CountDownLatch(1);
        StreamObserver<Number> res = new StreamObserver<>() {
            @Override
            public void onNext(Number value) {
                result[0] =value.getValue();
                System.out.println("[server to client] "+value.getValue());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error getMessage() = " + t.getMessage());
                timeForWait.countDown();
            }

            @Override
            public void onCompleted() {
                timeForWait.countDown();
            }
        };
        StreamObserver<Message> req = stub.clientStreaming(res);
        try {
            String[] msg = {"message #1", "message #2", "message #3", "message #4", "message #5"};
            for (String sndMsg : msg) {
                System.out.println("[client to server] " + sndMsg);
                req.onNext(Message.newBuilder().setMessage(sndMsg).build());
            }
            req.onCompleted();
            timeForWait.await(1,TimeUnit.MINUTES);
        } catch (Exception e) {
            req.onError(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return result[0];
    }
}
