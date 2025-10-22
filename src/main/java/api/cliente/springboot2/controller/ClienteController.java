package api.cliente.springboot2.controller;

import api.cliente.springboot2.domain.cliente.Cliente;
import api.cliente.springboot2.service.ClienteService;
import api.cliente.springboot2.util.DateUtil;
import dto.ClientePutDto;
import dto.ClienteRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {
    private final DateUtil dateUtil;
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(clienteService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Optional<Cliente>> findByName(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.findByName(nome));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequestDto clienteRequestDto){
        return new ResponseEntity<>(clienteService.save(clienteRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody ClientePutDto clientePutDto){
        clienteService.replace(clientePutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}