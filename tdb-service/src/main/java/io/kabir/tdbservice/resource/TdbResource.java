package io.kabir.tdbservice.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TdbResource {

    @Value("${server.port}")
    private String portNumber;
    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/ping")
    public String getPing() {
        return "PONG from : " + appName + " : " + portNumber;
    }
}
