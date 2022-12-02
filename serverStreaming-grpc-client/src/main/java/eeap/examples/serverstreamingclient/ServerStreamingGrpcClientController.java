package eeap.examples.serverstreamingclient;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServerStreamingGrpcClientController {
    private final ServerStreamingGrpcClientService service;

    @GetMapping("/serverStreaming")
    public List<String> serverStreaming() {
        List<String> list = service.sendValue();
        return Collections.singletonList(new Gson().toJson(list));
    }
}
