package mapper;

import api.cliente.springboot2.domain.cliente.Cliente;
import dto.ClientePutDto;
import dto.ClienteRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    // O Spring se encarrega de criar a instância (bean)
    // Você não precisa mais da linha 'public static final ClienteMapper INSTANCE...'

    public abstract Cliente toCliente(ClienteRequestDto clienteRequestDto);

    public abstract Cliente toCliente(ClientePutDto clientePutDto);
}