package org.jonathanzepeda.ConfiguracionInicial.data.postgresql;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}