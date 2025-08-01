package mapper;

import api.cliente.springboot2.domain.Usuario;
import dto.UsuarioPutDto;
import dto.UsuarioRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public abstract class UsuarioMapper {
    public abstract Usuario toUsuario (UsuarioRequestDto usuarioRequestDto);

    public abstract Usuario toUsuario (UsuarioPutDto usuarioPutDto);

}
