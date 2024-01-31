package org.jonathanzepeda.ConfiguracionInicial;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.jonathanzepeda.ConfiguracionInicial.data.UsuarioService;
import org.jonathanzepeda.ConfiguracionInicial.data.postgresql.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@SpringBootApplication
public class ConfiguracionInicialApplication  {

	public static void main(String[] args) {

		// Iniciar la aplicación Spring Boot
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfiguracionInicialApplication.class, args);

		// Obtener el servicio de usuarios del contexto de la aplicación
		UsuarioService usuarioService = applicationContext.getBean(UsuarioService.class);

		// Crear un nuevo usuario
		Usuario nuevoUsuario = new Usuario("jonathan", "nuevo.usuario@ejemplo.com");
		usuarioService.crearUsuario(nuevoUsuario);
		System.out.println("Usuario creado: " + nuevoUsuario);

		// Obtener todos los usuarios
		System.out.println("Todos los usuarios:");
		usuarioService.obtenerTodos().forEach(System.out::println);

		// Obtener un usuario por su ID
		Long usuarioId = 1L; // Ajusta el ID según tus datos
		Usuario usuarioPorId = usuarioService.obtenerPorId(usuarioId);
		System.out.println("Usuario con ID " + usuarioId + ": " + usuarioPorId);

		// Actualizar un usuario
		if (usuarioPorId != null) {
			usuarioPorId.setNombre("Nombre Actualizado");
			usuarioPorId.setCorreo("correo.actualizado@ejemplo.com");
			usuarioService.actualizarUsuario(usuarioId, usuarioPorId);
			System.out.println("Usuario actualizado: " + usuarioService.obtenerPorId(usuarioId));
		}
		usuarioId = 2L; // Ajusta el ID según tus datos
		// Eliminar un usuario
		if (usuarioPorId != null) {
			usuarioService.eliminarUsuario(usuarioId);
			System.out.println("Usuario eliminado. Todos los usuarios después de eliminar:");
			usuarioService.obtenerTodos().forEach(System.out::println);
		}

		// Cerrar la aplicación Spring Boot
		//applicationContext.close();
		/*SpringApplication.run(ConfiguracionInicialApplication.class, args);
		//En el navegador colocar: http://localhost:15467/doc/swagger-ui/index.html


		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(ConfiguracionInicialApplication.class, args);
		UsuarioService userService = applicationContext.getBean(UsuarioService.class);

		userService.crearUsuario(new org.jonathanzepeda.ConfiguracionInicial.data.postgresql.Usuario("jonathan zepeda", "jonathan.zepeda@prueba.com"));
		List<org.jonathanzepeda.ConfiguracionInicial.data.postgresql.Usuario> all = userService.obtenerTodos();
		for (org.jonathanzepeda.ConfiguracionInicial.data.postgresql.Usuario user : all) {
			System.out.println(user);
		}*/
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
