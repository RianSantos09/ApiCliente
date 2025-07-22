package api.cliente.springboot2.controller;

import api.cliente.springboot2.domain.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @GetMapping(path = "list")
 public List<Cliente> list(){
    return List.of(new Cliente( "rian"), new Cliente("jonatas"));
 }
}
