package org.jonathanzepeda.ConfiguracionInicial.data;

import org.jonathanzepeda.ConfiguracionInicial.data.postgresql.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
}
