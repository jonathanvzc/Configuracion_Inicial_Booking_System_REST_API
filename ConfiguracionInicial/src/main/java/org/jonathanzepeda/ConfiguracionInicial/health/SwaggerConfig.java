package org.jonathanzepeda.ConfiguracionInicial.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support")
public class SwaggerConfig {

    @GetMapping
    public String hide() {
        return "hide";
    }
}
