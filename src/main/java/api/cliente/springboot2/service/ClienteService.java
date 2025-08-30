package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.cliente.Cliente;
import api.cliente.springboot2.exception.BadRequestException;
import api.cliente.springboot2.repository.ClienteRepository;
import dto.ClientePutDto;
import dto.ClienteRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mapper.ClienteMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByName(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente findByIdOrThrowBadRequestException(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente save(ClienteRequestDto clienteRequestDto) {
        Cliente cliente = clienteMapper.toCliente(clienteRequestDto);
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(ClientePutDto clientePutDto) {
        Cliente savedCliente = findByIdOrThrowBadRequestException(clientePutDto.getId());
        Cliente clienteToUpdate = clienteMapper.toCliente(clientePutDto);
        clienteToUpdate.setId(savedCliente.getId());

        clienteRepository.save(clienteToUpdate);
    }
}