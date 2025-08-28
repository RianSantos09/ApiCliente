package dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class ClienteRequestDto {

    @NotEmpty(message = "Nome obrigatório")
    @NotNull(message = "Nome obrigatório")
    private String nome;

    @NotEmpty(message = "CPF/CNPJ obrigatório")
    @NotNull(message = "CPF/CNPJ obrigatório")
    private String cpfCnpj;

    private String telefone;
    private String endereco;
    private String historicoDeCompras;
    private double limiteDeCredito;
}