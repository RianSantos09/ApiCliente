package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario; // O nome da classe é Usuario, não PerfilDeUsuario
import api.cliente.springboot2.exception.BadRequestException;
import api.cliente.springboot2.repository.UsuarioRepository;
import dto.UsuarioPutDto;
import dto.UsuarioRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> findByName(String name) {
        return usuarioRepository.findByName(name);
    }

    public Usuario findByIdOrThrowBadRequestException(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Usuário não encontrado"));
    }

    @Transactional
    public Usuario save(UsuarioRequestDto usuarioRequestDto) {
        // Mapeia o DTO diretamente para a entidade Usuario,
        // que já contém os campos de perfil.
        Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioRequestDto);
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(UsuarioPutDto usuarioPutDto) {
        Usuario savedUsuario = findByIdOrThrowBadRequestException(usuarioPutDto.getId());

        // Mapeia o DTO de atualização para a entidade Usuario.
        // O Mapper já lida com todos os campos, incluindo os de perfil.
        Usuario usuarioToUpdate = UsuarioMapper.INSTANCE.toUsuario(usuarioPutDto);

        // Mantém o ID original do usuário salvo
        usuarioToUpdate.setId(savedUsuario.getId());

        // Salva a entidade atualizada
        usuarioRepository.save(usuarioToUpdate);
    }
}