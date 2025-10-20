package mapper;

import api.cliente.springboot2.domain.cliente.Cliente;
import dto.ClientePutDto;
import dto.ClienteRequestDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-20T11:25:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl extends ClienteMapper {

    @Override
    public Cliente toCliente(ClienteRequestDto clienteRequestDto) {
        if ( clienteRequestDto == null ) {
            return null;
        }

        Cliente.ClienteBuilder<?, ?> cliente = Cliente.builder();

        cliente.cpfCnpj( clienteRequestDto.getCpfCnpj() );
        cliente.nome( clienteRequestDto.getNome() );
        cliente.telefone( clienteRequestDto.getTelefone() );
        cliente.endereco( clienteRequestDto.getEndereco() );
        cliente.historicoDeCompras( clienteRequestDto.getHistoricoDeCompras() );
        cliente.limiteDeCredito( clienteRequestDto.getLimiteDeCredito() );

        return cliente.build();
    }

    @Override
    public Cliente toCliente(ClientePutDto clientePutDto) {
        if ( clientePutDto == null ) {
            return null;
        }

        Cliente.ClienteBuilder<?, ?> cliente = Cliente.builder();

        cliente.id( clientePutDto.getId() );
        cliente.cpfCnpj( clientePutDto.getCpfCnpj() );
        cliente.nome( clientePutDto.getNome() );
        cliente.telefone( clientePutDto.getTelefone() );
        cliente.endereco( clientePutDto.getEndereco() );
        cliente.historicoDeCompras( clientePutDto.getHistoricoDeCompras() );
        cliente.limiteDeCredito( clientePutDto.getLimiteDeCredito() );

        return cliente.build();
    }
}
