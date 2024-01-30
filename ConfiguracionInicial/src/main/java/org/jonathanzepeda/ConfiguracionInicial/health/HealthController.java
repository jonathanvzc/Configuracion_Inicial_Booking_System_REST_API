package org.jonathanzepeda.ConfiguracionInicial.health;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HealthController {

    @GetMapping
    public String getAll() {
        return "all";
    }

    @PostMapping
    public String create(@RequestBody String test) {
        return test;
    }
   }

