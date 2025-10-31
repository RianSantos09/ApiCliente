package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.Usuario;
import api.cliente.springboot2.repository.UsuarioRepository;
import dto.UsuarioRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Tag("Service")
@Tag("Usuario")
@Tag("Prioridade:Alta")
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @Tag("Leitura")
    @DisplayName("deve retornar um usuario")
    public void listAll_test() {
        Usuario usuario=new Usuario(1L,"Rian santos","riansantos@gmail.com","d",10,"todas","adm");
        String nomeEsperado = "Rian santos";
        Mockito.when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));

        List<Usuario> usuarios = usuarioService.listAll();
        //tem 1 usuario na lista?
        Assertions.assertEquals(1,usuarios.size());
        //lista não esta nula?
        Assertions.assertNotNull(usuarios, "A lista de usuários não deve ser nula.");
        //a permissão do usuario é a esperada?
        assertTrue(usuario.getPermissoes().contains("todas"), "O usuário deve ter a permissão 'todas'.");
        //o nome do usuario é o esperado?
        Assertions.assertEquals(nomeEsperado, usuarios.get(0).getName(), "O nome do primeiro usuário deve ser 'Rian santos'.");

    }

    @Test
    @Tag("Escrita")
    @DisplayName("salvar usuario")
    public void save_test(){
        String nomeEsperado = "Rian dos santos";
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto(nomeEsperado,"riansantos@dev.com","testando",10,"todas","adm");

        usuarioService.save(usuarioRequestDto);

        //verifica tempo de execução
        assertTimeout(Duration.ofMillis(100), () -> {
            usuarioService.save(usuarioRequestDto);
        }, "A operação de salvar não deve levar mais de 100ms.");

        //o metodo save  foi chamado duas vezes?
        verify(usuarioRepository, times(2)).save(any(Usuario.class));

    }
}

/*
 Assertions.assertEquals
 Assertions.assertNotNull
 assertTrue
 assertTimeout
 verify

    Tag("Servico")
    Tag("Usuario")
    Tag("Prioridade:Alta")
    Tag("Leitura")
    Tag("Escrita")
*/