package eeap.examples.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UnaryGrpcClientController {
    private final UnaryGrpcClientService service;

    @GetMapping("/unary")
    public int printNumber() {
        return service.sendNumber();
    }
}
