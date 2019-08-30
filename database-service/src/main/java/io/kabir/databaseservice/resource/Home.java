package io.kabir.databaseservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String home(){
        return "<H1> Database Service </H1>";
    }
}
