package io.kabir.databaseservice.resource;

import io.kabir.databaseservice.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/database")
public class DatabaseResource {

    @GetMapping("/{Id}")
    public Model getValue(@PathVariable("Id") String Id) {
        System.out.println("Database Server - Serving : " + Id + " at " + Instant.now().toString());
        return new Model(Id, "Name from Database Service");
    }
}
