package api.cliente.springboot2.domain.cliente;

import api.cliente.springboot2.domain.pessoa.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder

public class Cliente extends Pessoa {
    private String historicoDeCompras;
    private double limiteDeCredito;
}