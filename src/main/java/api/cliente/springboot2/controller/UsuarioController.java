package api.cliente.springboot2.controller;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.service.UsuarioService;
import api.cliente.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController // Marca esta classe como um controlador REST, o que significa que ela lida com requisições web e retorna dados diretamente (ex: JSON/XML)
@RequestMapping("usuarios") // Mapeia todas as requisições que começam com "/usuario" para este controlador
@Log4j2 // Fornece um objeto 'log' (ex: 'log.info()') para registrar mensagens no console/arquivo de log
@RequiredArgsConstructor // Gera um construtor para campos 'final'.

public class UsuarioController {
    private final DateUtil dateUtil;
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<Usuario>> list() { // O método retorna uma lista de objetos Cliente.
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<> (usuarioService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity <Usuario>findById(@PathVariable Long id) { // O método retorna uma lista de objetos Cliente.

        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity <Usuario> save( @RequestBody Usuario usuario){
        return new  ResponseEntity<>(usuarioService.save(usuario),HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity <?> delete(@PathVariable long id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity <?> replace( @RequestBody Usuario usuario){
        usuarioService.replace(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
