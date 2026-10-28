package cacaaoserros;

public class Solicitante {
    private final String nome;

    public Solicitante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
