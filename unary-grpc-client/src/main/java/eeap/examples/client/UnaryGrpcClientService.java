package eeap.examples.client;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.eeap.examples.lib.Number;
import org.eeap.examples.lib.RouteRpcGrpc;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UnaryGrpcClientService {
    @GrpcClient("unary")
    private RouteRpcGrpc.RouteRpcBlockingStub stub;
    private final int value = 4;
    public int sendNumber() {
        try {
            Number res = stub.myFunction(Number.newBuilder().setValue(4).build());
            System.out.println("gRPC result = " + res.getValue());
            return res.getValue();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
