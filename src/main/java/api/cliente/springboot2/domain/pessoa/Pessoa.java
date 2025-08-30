package api.cliente.springboot2.domain.pessoa;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Pessoa {

    @Id // O campo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // Garante que o CPF/CNPJ é único
    private String cpfCnpj;

    private String nome;
    private String telefone;
    private String endereco;
}