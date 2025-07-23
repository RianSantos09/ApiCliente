package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UsuarioService {
    private static List<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>(List.of(new Usuario(1l, "rian", "12345"), new Usuario(2l, "jonatas", "123456")));
    }

    public List<Usuario> listAll() {
        return usuarios;
    }

    public Usuario findById(long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "USUARIO NOT FOUND"));
    }

    public Usuario save(Usuario usuario) {
        usuario.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        usuarios.add(usuario);

        return usuario;
    }

}