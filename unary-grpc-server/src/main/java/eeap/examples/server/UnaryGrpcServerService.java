package eeap.examples.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.eeap.examples.lib.Number;
import org.eeap.examples.lib.RouteRpcGrpc;

@GrpcService
public class UnaryGrpcServerService extends RouteRpcGrpc.RouteRpcImplBase {
    @Override
    public void myFunction(Number request, StreamObserver<Number> responseObserver) {
        Number res = Number.newBuilder()
                .setValue(request.getValue()*request.getValue())
                .build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
