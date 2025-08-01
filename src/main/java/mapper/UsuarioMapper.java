package mapper;

import api.cliente.springboot2.domain.Usuario;
import dto.UsuarioPutDto;
import dto.UsuarioRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" )
public abstract class UsuarioMapper {

    public static final UsuarioMapper INSTANCE= Mappers.getMapper(UsuarioMapper.class);
    public abstract Usuario toUsuario (UsuarioRequestDto usuarioRequestDto);

    public abstract Usuario toUsuario (UsuarioPutDto usuarioPutDto);

}
