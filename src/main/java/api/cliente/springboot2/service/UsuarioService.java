package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class UsuarioService {

private final  UsuarioRepository usuarioRepository;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuario não encontrado"));
    }

    public Usuario save(Usuario usuario) {
        usuario.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        usuarios.add(usuario);

        return usuario;
    }

    public void delete(Long id) {
        usuarios.remove(findById(id));
    }

    public void replace(Usuario usuario) {
        delete(usuario.getId());
        usuarios.add(usuario);
    }
}