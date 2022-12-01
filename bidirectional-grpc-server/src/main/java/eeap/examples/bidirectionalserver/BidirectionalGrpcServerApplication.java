package eeap.examples.bidirectionalserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BidirectionalGrpcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidirectionalGrpcServerApplication.class, args);
	}

}
