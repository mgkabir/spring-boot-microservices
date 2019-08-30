package io.kabir.databaseservice.resource;

import io.kabir.databaseservice.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DatabaseResource {

    @GetMapping("/{Id}")
    public Model getValue(@PathVariable("Id") String Id) {
        return new Model(Id, "Database Object");
    }
}
