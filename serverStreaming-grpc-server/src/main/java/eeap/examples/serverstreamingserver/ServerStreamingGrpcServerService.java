package eeap.examples.serverstreamingserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.eeap.examples.lib.Message;
import org.eeap.examples.lib.Number;
import org.eeap.examples.lib.RouteRpcGrpc;

@GrpcService
public class ServerStreamingGrpcServerService extends RouteRpcGrpc.RouteRpcImplBase {
    @Override
    public void serverStreaming(Number request, StreamObserver<Message> responseObserver) {
        // 1보다 작은 값일 경우 error 처리
        if (request.getValue() < 1) {
            responseObserver.onError(new Throwable());
        } else {
            for (int cnt = 1; cnt < request.getValue()+1; cnt++) {
                responseObserver
                        .onNext(Message.newBuilder()
                                .setMessage("message #" + cnt)
                                .build());
            }
            System.out.printf("Server processing gRPC server-streaming {%d}\n", request.getValue());
            responseObserver.onCompleted();
        }
    }
}
