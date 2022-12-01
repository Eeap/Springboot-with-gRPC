package eeap.examples.bidirectionalclient;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BidirectionalGrpcClientController {
    private final BidirectionalGrpcClientService service;

    @GetMapping("/bidirectional")
    public List<String> bidirectionalStreaming() {
        List<String> list = service.sendMessage();
        return Collections.singletonList(new Gson().toJson(list));
    }
}
