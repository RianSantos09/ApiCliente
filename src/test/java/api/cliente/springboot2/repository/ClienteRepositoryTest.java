package api.cliente.springboot2.repository;

import api.cliente.springboot2.domain.cliente.Cliente;
import dto.ClientePutDto;
import dto.ClienteRequestDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")

class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void findByNome() {
        String nome ="rian santos";
        ClientePutDto data = new ClientePutDto();
        data.setCpfCnpj("12345678900");
        data.setNome(nome);
        data.setTelefone("11988887777");
        data.setEndereco("rua dos croa, 47 - São Gabriel");

        this.createCliente(data);

        Optional <Cliente> result = this.clienteRepository.findByNome(nome);

        assertThat(result.isPresent()).isTrue();


    }


    private Cliente createCliente(ClientePutDto data) {
        Cliente newCliente = Cliente.builder()
                .cpfCnpj(data.getCpfCnpj())
                .nome(data.getNome())
                .telefone(data.getTelefone())
                .endereco(data.getEndereco())
                .build();

        this.entityManager.persist(newCliente);
        return newCliente;
    }



}