package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService  {
    private List<Usuario> usuarios =  List.of(new Usuario(1l ,"rian"), new Usuario(2l, "jonatas"));

    public List<Usuario>listAll(){
        return usuarios;
    }

    public Usuario findById (long id){
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"USUARIO NOT FOUND"));
    }
}
