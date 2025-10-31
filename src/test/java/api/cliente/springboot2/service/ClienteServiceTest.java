package api.cliente.springboot2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import api.cliente.springboot2.domain.cliente.Cliente;
import api.cliente.springboot2.repository.ClienteRepository;
import api.cliente.springboot2.service.ClienteService;
import dto.ClienteRequestDto;
import mapper.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

class ClienteServiceTest {


    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

    private final Long CLIENTE_ID = 5L;
    private ClienteRequestDto requestDto;
    private Cliente clienteParaSalvar;
    private Cliente clienteSalvoComId;

    @BeforeEach
    void save_test() {
        requestDto = new ClienteRequestDto();
        requestDto.setNome("clente Teste");
        requestDto.setCpfCnpj("00011122233");

        clienteParaSalvar = new Cliente();
        clienteParaSalvar.setNome("clente Teste");
        clienteParaSalvar.setCpfCnpj("00011122233");

        clienteSalvoComId = new Cliente();
        clienteSalvoComId.setId(5L); // Simula o ID gerado pelo banco
        clienteSalvoComId.setNome("clente Teste");
        clienteSalvoComId.setCpfCnpj("00011122233");
    }

    @Test
    void save_e_mapper() {

        when(clienteMapper.toCliente(requestDto))
                .thenReturn(clienteParaSalvar);

        when(clienteRepository.save(clienteParaSalvar))
                .thenReturn(clienteSalvoComId);

        Cliente resultado = clienteService.save(requestDto);

        assertNotNull(resultado, "O objeto Cliente não deve ser nulo.");
        assertEquals(5L, resultado.getId(), "O ID do cliente deve ser o simulado (5L).");
        assertEquals("clente Teste", resultado.getNome(), "O nome deve ser o mesmo do dado manual.");

        verify(clienteMapper, times(1)).toCliente(requestDto);

        verify(clienteRepository, times(1)).save(clienteParaSalvar);
    }

    @BeforeEach
    void setupClienteData() {

        requestDto = new ClienteRequestDto();
        requestDto.setNome("clente Teste");
        requestDto.setCpfCnpj("00011122233");

        clienteParaSalvar = new Cliente();
        clienteParaSalvar.setNome("clente Teste");
        clienteParaSalvar.setCpfCnpj("00011122233");

        clienteSalvoComId = new Cliente();
        clienteSalvoComId.setId(CLIENTE_ID);
        clienteSalvoComId.setNome("clente Teste");
        clienteSalvoComId.setCpfCnpj("00011122233");
    }

    @Test
    void delete_by_id() {
        final Long CLIENTE_ID = 5L;

        when(clienteRepository.findById(CLIENTE_ID))
                .thenReturn(Optional.of(clienteSalvoComId));

        doNothing().when(clienteRepository).delete(clienteSalvoComId);
        clienteService.delete(CLIENTE_ID);

        verify(clienteRepository, times(1)).findById(CLIENTE_ID);
        verify(clienteRepository, times(1)).delete(clienteSalvoComId);
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void listAll() {
    }
}
