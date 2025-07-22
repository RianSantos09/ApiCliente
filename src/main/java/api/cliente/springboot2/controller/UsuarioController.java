package api.cliente.springboot2.controller;

import api.cliente.springboot2.domain.Cliente;
import api.cliente.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController // Marca esta classe como um controlador REST, o que significa que ela lida com requisições web e retorna dados diretamente (ex: JSON/XML)
@RequestMapping("usuario") // Mapeia todas as requisições que começam com "/usuario" para este controlador
@Log4j2 // Fornece um objeto 'log' (ex: 'log.info()') para registrar mensagens no console/arquivo de log
@RequiredArgsConstructor // Gera um construtor para campos 'final'.
// Ao tornar 'dateUtil' final, o Spring injetará a dependência via construtor,
// tornando a anotação @Autowired explícita desnecessária e promovendo imutabilidade.
public class UsuarioController {

    // Declara uma instância de DateUtil. Ao torná-la 'final', o @RequiredArgsConstructor
    // garantirá que ela seja injetada pelo Spring via construtor.
    // O modificador 'final' aqui assegura que a instância de 'dateUtil' seja atribuída apenas uma vez (pelo construtor).
    private final DateUtil dateUtil;

    @GetMapping(path = "list") // Esta anotação mapeia as requisições GET que chegam em "/usuario/list" para este método.
    public List<Cliente> list() { // O método retorna uma lista de objetos Cliente.

        // Registra uma mensagem informativa no log.
        // em um formato legível para banco de dados. Isso ajuda a rastrear acessos e operações no endpoint.
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        // Retorna uma lista imutável de dois objetos Cliente, "rian" e "jonatas".
        // Esta é uma simulação para fins de exemplo.
        return List.of(new Cliente("rian"), new Cliente("jonatas"));
    }
}
