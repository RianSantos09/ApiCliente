package api.cliente.springboot2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class ApplicationStart { // Nome da classe principal que contém o método main para iniciar a aplicação

    public static void main(String[] args) {
        // Método estático da classe SpringApplication que inicia a aplicação Spring Boot.
        // Ele realiza a inicialização do contexto da aplicação, configura beans, etc.
        SpringApplication.run(ApplicationStart.class, args);
    }
}
