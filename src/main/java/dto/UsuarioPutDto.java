package dto;

import lombok.Data;

@Data
public class UsuarioPutDto {

    private Long id;
    private  String name;
    private String email;
    private String senha;
}
