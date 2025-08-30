package mapper;

import api.cliente.springboot2.domain.fornecedor.Fornecedor;
import dto.FornecedorPutDto;
import dto.FornecedorRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FornecedorMapper {

    // O Spring se encarrega de criar o bean. Não use a instância estática com componentModel="spring".

    // Mapeia de FornecedorRequestDto para Fornecedor
    public abstract Fornecedor toFornecedor(FornecedorRequestDto fornecedorRequestDto);

    // Mapeia de FornecedorPutDto para Fornecedor
    public abstract Fornecedor toFornecedor(FornecedorPutDto fornecedorPutDto);

    // Método customizado para mapear List<String> para String
    protected String mapProdutos(List<String> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            return null;
        }
        // Concatena a lista em uma única String, separando os itens por vírgula
        return String.join(",", produtos);
    }
}