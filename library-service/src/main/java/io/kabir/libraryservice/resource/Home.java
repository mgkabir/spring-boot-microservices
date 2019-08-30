package io.kabir.libraryservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Home {

    @GetMapping("/")
    public String home(){
        return "<H1> Library Service </H1>";
    }
}
