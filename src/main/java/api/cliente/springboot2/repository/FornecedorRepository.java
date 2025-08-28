package api.cliente.springboot2.repository;

import api.cliente.springboot2.domain.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findByNome(String nome);
}