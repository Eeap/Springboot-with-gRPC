package eeap.examples.bidirectionalserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.eeap.examples.lib.Message;
import org.eeap.examples.lib.RouteRpcGrpc;

@GrpcService
public class BidirectionalGrpcServerService extends RouteRpcGrpc.RouteRpcImplBase {
    @Override
    public StreamObserver<Message> bidirectional(StreamObserver<Message> responseObserver) {
        System.out.println("Server processing gRPC bidirectional streaming");
        return new StreamObserver<Message>() {
            @Override
            public void onNext(Message value) {
                responseObserver.onNext(value);
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
