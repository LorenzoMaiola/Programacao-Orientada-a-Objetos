package SonoraV2Lista04;

public class Usuario {
    private static int contador = 0;

    private final int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.id = ++contador;
        setNome(nome);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome.isBlank() || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (email.isEmpty() || email.isBlank())
            throw new IllegalArgumentException("O email não pode ser vazio!");
        else if (!email.contains("@"))
            throw new IllegalArgumentException("O email deve conter um @");
        this.email = email;
    }
}