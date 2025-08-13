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
    @NotEmpty(message = "senha obrigatoria")
    @NotNull(message = "senha obrigatoria")
    private String senha;
}
