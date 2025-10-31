package api.cliente.springboot2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)




    private Long id;
    private String name;
    private String email;
    private String senha;
    // 1* sprint
    private int nivelDeAcesso;
    private String permissoes;
    private String descricao;

    public Usuario(long l, String name, String email, String senha, String permissoes, String descricao) {
    }



    //

}


