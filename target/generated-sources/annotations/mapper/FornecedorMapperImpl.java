package mapper;

import api.cliente.springboot2.domain.fornecedor.Fornecedor;
import dto.FornecedorPutDto;
import dto.FornecedorRequestDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-20T11:25:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class FornecedorMapperImpl extends FornecedorMapper {

    @Override
    public Fornecedor toFornecedor(FornecedorRequestDto fornecedorRequestDto) {
        if ( fornecedorRequestDto == null ) {
            return null;
        }

        Fornecedor.FornecedorBuilder<?, ?> fornecedor = Fornecedor.builder();

        fornecedor.cpfCnpj( fornecedorRequestDto.getCpfCnpj() );
        fornecedor.nome( fornecedorRequestDto.getNome() );
        fornecedor.telefone( fornecedorRequestDto.getTelefone() );
        fornecedor.endereco( fornecedorRequestDto.getEndereco() );
        fornecedor.produtosFornecidos( mapProdutos( fornecedorRequestDto.getProdutosFornecidos() ) );
        fornecedor.prazoDeEntrega( fornecedorRequestDto.getPrazoDeEntrega() );

        return fornecedor.build();
    }

    @Override
    public Fornecedor toFornecedor(FornecedorPutDto fornecedorPutDto) {
        if ( fornecedorPutDto == null ) {
            return null;
        }

        Fornecedor.FornecedorBuilder<?, ?> fornecedor = Fornecedor.builder();

        fornecedor.id( fornecedorPutDto.getId() );
        fornecedor.cpfCnpj( fornecedorPutDto.getCpfCnpj() );
        fornecedor.nome( fornecedorPutDto.getNome() );
        fornecedor.telefone( fornecedorPutDto.getTelefone() );
        fornecedor.endereco( fornecedorPutDto.getEndereco() );
        fornecedor.produtosFornecidos( mapProdutos( fornecedorPutDto.getProdutosFornecidos() ) );
        fornecedor.prazoDeEntrega( fornecedorPutDto.getPrazoDeEntrega() );

        return fornecedor.build();
    }
}
