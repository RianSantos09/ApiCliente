package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService  {
    public List<Usuario>listAll(){
        return List.of(new Usuario(1l ,"rian"), new Usuario(2l, "jonatas"));
    }
}
