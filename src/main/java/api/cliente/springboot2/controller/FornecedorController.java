package api.cliente.springboot2.controller;

import api.cliente.springboot2.domain.fornecedor.Fornecedor;
import api.cliente.springboot2.service.FornecedorService;
import api.cliente.springboot2.util.DateUtil;
import dto.FornecedorPutDto;
import dto.FornecedorRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("fornecedores")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FornecedorController {
    private final DateUtil dateUtil;
    private final FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(fornecedorService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Fornecedor>> findByName(@RequestParam String nome) {
        return ResponseEntity.ok(fornecedorService.findByName(nome));
    }

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody @Valid FornecedorRequestDto fornecedorRequestDto){
        return new ResponseEntity<>(fornecedorService.save(fornecedorRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        fornecedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody FornecedorPutDto fornecedorPutDto){
        fornecedorService.replace(fornecedorPutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}