package dto;

import lombok.Data;
import java.util.List;

@Data
public class FornecedorPutDto {
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String endereco;
    private List<String> produtosFornecidos;
    private int prazoDeEntrega;
}