package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.repository.UsuarioRepository;
import dto.UsuarioPutDto;
import dto.UsuarioRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class UsuarioService {

private final  UsuarioRepository usuarioRepository;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByIdOrThrowBadRequestException(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuario não encontrado"));
    }

    public Usuario save( UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario= Usuario.builder().name(usuarioRequestDto.getName()).build();

        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(UsuarioPutDto usuarioPutDto) {
        Usuario saveUsuario = findByIdOrThrowBadRequestException (usuarioPutDto.getId());
        Usuario usuario =Usuario.builder()
                .id(saveUsuario.getId())
                .name(usuarioPutDto.getName())
                .build();

        usuarioRepository.save(usuario);
    }
}