package mapper;

import api.cliente.springboot2.domain.cliente.Cliente;
import dto.ClientePutDto;
import dto.ClienteRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    public abstract Cliente toCliente(ClienteRequestDto clienteRequestDto);
    public abstract Cliente toCliente(ClientePutDto clientePutDto);
}