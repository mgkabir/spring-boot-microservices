package io.kabir.consulclient;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.concurrent.TimeUnit;

@Configuration
@Order(Ordered.LOWEST_PRECEDENCE)
public class UnRegisterConsulClient implements CommandLineRunner {
    @Value("${spring.application.name}")
    private String name;

    @Override
    public void run(String... args) throws Exception {
        TimeUnit.SECONDS.sleep(60);
        ConsulClient client = new ConsulClient("localhost");
        client.getAgentServices().getValue().forEach((k, v) -> {
            if (v.getService().equalsIgnoreCase(name)) {
                System.out.println("De-Registering : " + v.getService());
                client.agentServiceDeregister(k);
            }
        });
    }
}
