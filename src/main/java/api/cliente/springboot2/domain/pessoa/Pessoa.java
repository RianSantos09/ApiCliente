package api.cliente.springboot2.domain.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Pessoa {
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String endereco;
}
