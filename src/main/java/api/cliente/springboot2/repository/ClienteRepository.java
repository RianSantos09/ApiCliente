package api.cliente.springboot2.repository;

import api.cliente.springboot2.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
}