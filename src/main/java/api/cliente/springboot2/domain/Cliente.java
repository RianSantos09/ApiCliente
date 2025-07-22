package api.cliente.springboot2.domain;

public class Cliente { // Declaração da classe Cliente. Esta é uma classe de modelo (ou "domain" / "POJO") que representa um cliente.
    private String name; // Campo privado para armazenar o nome do cliente. É privado para encapsulamento.


    public Cliente(String name) { // Construtor com um argumento 'name'
        this.name = name; // Atribui o valor passado para o campo 'name' da instância atual da classe.
    }


    public Cliente() { // Construtor sem argumentos (construtor padrão ou no-arg constructor)
    }


    public String getName() { // Método público para acessar o valor do campo 'name'
        return name; // Retorna o nome do cliente.
    }


    public void setName(String name) { // Método público para modificar o valor do campo 'name'
        this.name = name; // Define o novo valor para o nome do cliente.
    }
}