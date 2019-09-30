package io.kabir.consulclient;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RegisterWithConsul implements CommandLineRunner {
    @Value("${spring.application.name}")
    private String name;
    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        ConsulClient client = new ConsulClient("localhost");
        NewService newService = new NewService();
        newService.setId(name + "-" + port);
        newService.setName(name);
        newService.setPort(Integer.valueOf(port));
        newService.setTags(Arrays.asList("EU-West", "EU-East"));

        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setHttp("http://localhost:9091/actuator/health");
        serviceCheck.setInterval("5s");

        newService.setCheck(serviceCheck);
        //newService.setAddress("http://localhost");

        client.agentServiceRegister(newService);
    }
}
