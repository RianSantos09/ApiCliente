package api.cliente.springboot2.repository;

import api.cliente.springboot2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario>  findByName(String  name);

}
