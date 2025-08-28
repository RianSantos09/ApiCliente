package dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class FornecedorRequestDto {
    @NotEmpty(message = "Nome obrigatório")
    @NotNull(message = "Nome obrigatório")
    private String nome;

    @NotEmpty(message = "CPF/CNPJ obrigatório")
    @NotNull(message = "CPF/CNPJ obrigatório")
    private String cpfCnpj;

    private String telefone;
    private String endereco;
    private List<String> produtosFornecidos;
    private int prazoDeEntrega;
}