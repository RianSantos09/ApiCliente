package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.exception.BadRequestException;
import api.cliente.springboot2.repository.UsuarioRepository;
import dto.UsuarioPutDto;
import dto.UsuarioRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mapper.UsuarioMapper;
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

    public List<Usuario> findByName(String name) {

        return usuarioRepository.findByName(name);
    }

    public Usuario findByIdOrThrowBadRequestException(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("usuario não encontrado"));
    }

    @Transactional
    public Usuario save( UsuarioRequestDto usuarioRequestDto) {

        return usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioRequestDto));
    }

    public void delete(Long id) {
        usuarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(UsuarioPutDto usuarioPutDto) {
        Usuario saveUsuario = findByIdOrThrowBadRequestException (usuarioPutDto.getId());
        Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioPutDto);
        usuario.setId(saveUsuario.getId());
        usuarioRepository.save(usuario);
    }
}