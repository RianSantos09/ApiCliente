package mapper;

import api.cliente.springboot2.domain.Usuario;
import dto.UsuarioPutDto;
import dto.UsuarioRequestDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-20T11:25:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioRequestDto usuarioRequestDto) {
        if ( usuarioRequestDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.name( usuarioRequestDto.getName() );
        usuario.email( usuarioRequestDto.getEmail() );
        usuario.senha( usuarioRequestDto.getSenha() );
        if ( usuarioRequestDto.getNivelDeAcesso() != null ) {
            usuario.nivelDeAcesso( usuarioRequestDto.getNivelDeAcesso() );
        }
        usuario.permissoes( usuarioRequestDto.getPermissoes() );
        usuario.descricao( usuarioRequestDto.getDescricao() );

        return usuario.build();
    }

    @Override
    public Usuario toUsuario(UsuarioPutDto usuarioPutDto) {
        if ( usuarioPutDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.id( usuarioPutDto.getId() );
        usuario.name( usuarioPutDto.getName() );
        usuario.email( usuarioPutDto.getEmail() );
        usuario.senha( usuarioPutDto.getSenha() );
        usuario.nivelDeAcesso( usuarioPutDto.getNivelDeAcesso() );
        usuario.permissoes( usuarioPutDto.getPermissoes() );
        usuario.descricao( usuarioPutDto.getDescricao() );

        return usuario.build();
    }
}
