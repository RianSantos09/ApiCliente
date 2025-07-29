package api.cliente.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor

public class Usuario { // Declaração da classe Cliente. Esta é uma classe de modelo (ou "domain" / "POJO") que representa um cliente.


    private Long id;
    private String name;
    private  String senha;


}


