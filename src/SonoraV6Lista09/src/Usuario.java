import java.util.ArrayList;

public class Usuario {
    private static int contador = 0;

    private final int id;
    private String nome;
    private String email;
    private ArrayList<Usuario> seguindo;

    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);
        seguindo = new ArrayList<>();
        this.id = ++contador;
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
            throw new IllegalArgumentException(
                    "\nO email deve conter um \"@\".\"" + email + "\" não é um e-mail válido!");
        this.email = email;
    }

    public void seguir(Usuario outro) {
        if (outro.id == getId())
            throw new IllegalArgumentException("O usuário não pode seguir a si mesmo!");

        for (int i = 0; i < seguindo.size(); i++) {
            if (outro.id == seguindo.get(i).getId())
                throw new IllegalStateException("Não foi possível seguir. Esse usuário já é seguido!");
        }
        seguindo.add(outro);
    }

    public void deixarDeSeguir(Usuario outro) {
        if (outro.id != this.id) {
            if (seguindo.contains(outro))
                seguindo.remove(outro);
            else {
                throw new IllegalStateException("O usuário não existe na lista de seguindo.");
            }
        } else {
            throw new IllegalArgumentException("Não é possível deixar de seguir a si mesmo!");
        }
    }

    public int getQuantidadeSeguindo() {
        return seguindo.size();
    }

}