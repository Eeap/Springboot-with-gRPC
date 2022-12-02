package eeap.examples.clientstreamingserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.eeap.examples.lib.Message;
import org.eeap.examples.lib.Number;
import org.eeap.examples.lib.RouteRpcGrpc;

@GrpcService
public class ClientStreamingGrpcServerService extends RouteRpcGrpc.RouteRpcImplBase {
    @Override
    public StreamObserver<Message> clientStreaming(StreamObserver<Number> responseObserver) {
        System.out.println("Server processing gRPC client-streaming");
        return new StreamObserver<Message>() {
            int count = 0;
            @Override
            public void onNext(Message value) {
                count++;
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error getMessage() = " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(Number.newBuilder().setValue(count).build());
                responseObserver.onCompleted();
            }
        };
    }
}
