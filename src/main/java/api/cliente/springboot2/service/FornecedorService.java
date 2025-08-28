package api.cliente.springboot2.service;

import api.cliente.springboot2.domain.fornecedor.Fornecedor;
import api.cliente.springboot2.exception.BadRequestException;
import api.cliente.springboot2.repository.FornecedorRepository;
import dto.FornecedorPutDto;
import dto.FornecedorRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mapper.FornecedorMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public List<Fornecedor> listAll() {
        return fornecedorRepository.findAll();
    }

    public List<Fornecedor> findByName(String nome) {
        return fornecedorRepository.findByNome(nome);
    }

    public Fornecedor findByIdOrThrowBadRequestException(long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Fornecedor não encontrado"));
    }

    @Transactional
    public Fornecedor save(FornecedorRequestDto fornecedorRequestDto) {
        Fornecedor fornecedor = fornecedorMapper.toFornecedor(fornecedorRequestDto);
        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Long id) {
        fornecedorRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(FornecedorPutDto fornecedorPutDto) {
        Fornecedor savedFornecedor = findByIdOrThrowBadRequestException(fornecedorPutDto.getId());
        Fornecedor fornecedorToUpdate = fornecedorMapper.toFornecedor(fornecedorPutDto);
        fornecedorToUpdate.setId(savedFornecedor.getId());
        fornecedorRepository.save(fornecedorToUpdate);
    }
}