package api.cliente.springboot2.repository;

import api.cliente.springboot2.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
}