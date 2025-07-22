package api.cliente.springboot2.controller;

import api.cliente.springboot2.domain.Cliente;
import api.cliente.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("usuario")
@Log4j2
@AllArgsConstructor
public class UsuarioController {
    @Autowired
    private DateUtil dateUtil;
    @GetMapping(path = "list")
    public List<Cliente> list(){
       log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
       return List.of(new Cliente( "rian"), new Cliente("jonatas"));
 }
}
