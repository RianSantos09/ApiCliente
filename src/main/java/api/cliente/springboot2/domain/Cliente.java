package api.cliente.springboot2.domain;

public class Cliente {
    private String name;

    public Cliente(String name) {
        this.name = name;
    }

    public Cliente() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
