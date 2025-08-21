package api.cliente.springboot2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder


public class Usuario { // Declaração da classe Cliente. Esta é uma classe de modelo (ou "domain" / "POJO") que representa um cliente.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    private String senha;
    // 1* sprint
    private int nivelDeAcesso;
    private String permissoes;
    private String descricao;

}


