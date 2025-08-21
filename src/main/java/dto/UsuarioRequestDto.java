package dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDto {


    @NotEmpty(message = "nome obrigatorio")
    @NotNull(message = "nome obrigatorio")
    private String name;

    @NotEmpty(message = "email obrigatoria")
    @NotNull(message = "email obrigatoria")
    private String email;

    @NotEmpty(message = "senha obrigatoria")
    @NotNull(message = "senha obrigatoria")
    private String senha;

    // Novos atributos de perfil
    @NotNull(message = "Nível de acesso obrigatório")
    private Integer nivelDeAcesso;

    @NotEmpty(message = "Permissões obrigatórias")
    @NotNull(message = "Permissões obrigatórias")
    private String permissoes;

    @NotEmpty(message = "Descrição obrigatória")
    @NotNull(message = "Descrição obrigatória")
    private String descricao;
}
