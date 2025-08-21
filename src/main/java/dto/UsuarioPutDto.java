package dto;

import lombok.Data;

@Data
public class UsuarioPutDto {

    private Long id;
    private  String name;
    private String email;
    private String senha;

    // Novos atributos de perfil adicionados
    private int nivelDeAcesso;
    private String permissoes;
    private String descricao;
}
