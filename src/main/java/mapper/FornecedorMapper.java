package mapper;

import api.cliente.springboot2.domain.fornecedor.Fornecedor;
import dto.FornecedorPutDto;
import dto.FornecedorRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FornecedorMapper {
    public static final FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);
    public abstract Fornecedor toFornecedor(FornecedorRequestDto fornecedorRequestDto);
    public abstract Fornecedor toFornecedor(FornecedorPutDto fornecedorPutDto);
}