package api.cliente.springboot2.domain.fornecedor;

import api.cliente.springboot2.domain.pessoa.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Fornecedor extends Pessoa {

    // O JPA agora mapeará esta String para uma coluna de texto no banco de dados.
    private String produtosFornecidos;
    private int prazoDeEntrega;
}