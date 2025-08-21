package api.cliente.springboot2.domain.fornecedor;

import api.cliente.springboot2.domain.pessoa.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class Fornecedor extends Pessoa {
    private List<String> produtosFornecidos;
    private int prazoDeEntrega;
}
