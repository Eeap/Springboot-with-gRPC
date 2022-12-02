package eeap.examples.clientstreamingclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientStreamingGrpcClientController {
    private final ClientStreamingGrpcClientService service;

    @GetMapping("/clientStreaming")
    public int clientStreaming() {
        int result = service.sendMessage();
        return result;
    }
}
