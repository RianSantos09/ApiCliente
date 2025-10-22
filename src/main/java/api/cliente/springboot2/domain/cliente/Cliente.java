package api.cliente.springboot2.domain.cliente;

import api.cliente.springboot2.domain.pessoa.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity // Torna a classe Cliente uma entidade do JPA
@Data
@NoArgsConstructor
@SuperBuilder
public class Cliente extends Pessoa {

    private String historicoDeCompras;
    private double limiteDeCredito;



}