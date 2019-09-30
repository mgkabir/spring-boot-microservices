package io.kabir.consulclient;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class DiscoverConsulClient implements CommandLineRunner {
    @Value("${triplestore-service}")
    private String tdbService;
    @Override
    public void run(String... args) throws Exception {
        ConsulClient client = new ConsulClient("localhost");
        // query for healthy services based on name
        HealthServicesRequest request = HealthServicesRequest.newBuilder()
                .setPassing(true)
                .setQueryParams(QueryParams.DEFAULT)
                .build();

        Response<List<HealthService>> healthyServices = client.getHealthServices(tdbService, request);
        healthyServices.getValue().stream().forEach(healthService -> {
            System.out.println("Discovered Service (s): "+healthService.getService().toString());
        });
    }
}
