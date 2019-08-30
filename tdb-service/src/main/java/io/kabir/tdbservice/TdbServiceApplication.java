package io.kabir.tdbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TdbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdbServiceApplication.class, args);
	}

}
