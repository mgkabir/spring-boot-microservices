package io.kabir.databaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DatabaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}

}
