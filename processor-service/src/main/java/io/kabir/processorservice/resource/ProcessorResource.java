package io.kabir.processorservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProcessorResource {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ping")
    public String getPingFromTDB(){
        return this.restTemplate.getForObject("http://triplestore-service/ping",String.class);
    }
}
