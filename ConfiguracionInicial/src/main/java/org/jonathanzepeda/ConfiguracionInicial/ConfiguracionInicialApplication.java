package org.jonathanzepeda.ConfiguracionInicial;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ConfiguracionInicialApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ConfiguracionInicialApplication.class, args);
		//En el navegador colocar: http://localhost:15467/doc/swagger-ui/index.html
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("SACAViX Spring Boot 3 API -------")
						.version("0.11")
						.description("Sample app Spring Boot 3 with Swagger")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}

}
