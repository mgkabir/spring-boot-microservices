package io.kabir.libraryservice.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.kabir.libraryservice.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/library")
public class LibraryResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{Id}")
    @HystrixCommand(fallbackMethod = "getValueFromDatabaseFallback")
    public Model getValueFromDatabase(@PathVariable("Id") String Id) {

        ResponseEntity<Model> entity = restTemplate.getForEntity("http://database-service/database/" + Id, Model.class);
        Model model = entity.getBody();
        System.out.println("Response [ " + model.getId() + " : "+model.getName() +" ]");
        return model;

    }

    public Model getValueFromDatabaseFallback(@PathVariable("Id") String Id) {
        System.out.println("Response [ " + Id + " : Default Name ]");
        return new Model(Id,"Default Name");
    }
}
