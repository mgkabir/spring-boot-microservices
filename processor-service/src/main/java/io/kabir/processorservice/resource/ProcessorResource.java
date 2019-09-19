package io.kabir.processorservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProcessorResource {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/ping")
    public String getPingFromTDB() {
        /* Inspect some values using discoveryClient */
        discoveryClient
                .getInstances("triplestore-service")
                .stream()
                .forEach(this::displayServiceInstanceDetails);

        return this.restTemplate.getForObject("http://triplestore-service/ping", String.class);
    }

    private void displayServiceInstanceDetails(ServiceInstance serviceInstance) {
        System.out.println("URI : " + serviceInstance.getUri().toString() + " InstanceId : " + serviceInstance.getInstanceId() + " ServiceId : " + serviceInstance.getServiceId());
        serviceInstance.getMetadata().forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
    }
}
