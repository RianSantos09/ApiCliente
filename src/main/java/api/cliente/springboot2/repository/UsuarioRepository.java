package api.cliente.springboot2.repository;

import api.cliente.springboot2.domain.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listAll();
}
