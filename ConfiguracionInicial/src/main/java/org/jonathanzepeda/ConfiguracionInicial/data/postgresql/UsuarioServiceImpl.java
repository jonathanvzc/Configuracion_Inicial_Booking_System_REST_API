package org.jonathanzepeda.ConfiguracionInicial.data.postgresql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.jonathanzepeda.ConfiguracionInicial.data.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private final UsuarioRepository usuarioRepository;
    private Long idGenerador = 1L;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    @Transactional
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        try {
            System.out.println("ingreso1");
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            // Maneja la excepción si es necesario, o simplemente deja que se propague.
            throw new RuntimeException("Error al crear usuario", e);
            //e.printStackTrace(); // O manejar de acuerdo a tus necesidades
            //System.out.println("error");
           // return null; // O lanzar una excepción personalizada si es necesario
        }
       /* usuario.setId(idGenerador++);
        usuarios.put(usuario.getId(), usuario);
        return usuario;*/
    }

    @Override
    @Transactional
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuarioRepository.deleteById(id);
        }
    }
}