package eeap.examples.bidirectionalclient;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.eeap.examples.lib.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class BidirectionalGrpcClientService {
    @GrpcClient("bidirectional")
    private RouteRpcGrpc.RouteRpcStub stub; //비동기식 stub이라서 서버로부터 메시지를 받을 떄까지 기다리는 작업 필요
    private int count = 1;

    public List<String> sendMessage() {
        List<String> msgList = new ArrayList<>();
        final CountDownLatch timeForWait = new CountDownLatch(1);
        StreamObserver<Message> res = new StreamObserver<>() {
            @Override
            public void onNext(Message value) {
                System.out.println("[server to client] " + value.getMessage());
                msgList.add(value.getMessage());
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
        StreamObserver<Message> req = stub.bidirectional(res);
        try {
            String[] msg = {"message #1", "message #2", "message #3", "message #4", "message #5"};
            for (String sndMsg : msg) {
                System.out.println("[client to server] " + sndMsg);
                req.onNext(Message.newBuilder().setMessage(sndMsg).build());
            }
            req.onCompleted();
            timeForWait.await(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            req.onError(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return msgList;
    }


}
