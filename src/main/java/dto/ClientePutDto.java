package dto;

import lombok.Data;

@Data
public class ClientePutDto {
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String endereco;
    private String historicoDeCompras;
    private double limiteDeCredito;
}