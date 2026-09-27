import java.util.ArrayList;

public class Plataforma {

    private ArrayList<Musica> acervo;
    private int totalMusicas;

    private ArrayList<Usuario> usuarios;
    private int totalUsuarios;

    public Plataforma() {
        this.acervo = new ArrayList<>();
        this.totalMusicas = 0;
        this.usuarios = new ArrayList<>();
        this.totalUsuarios = 0;
    }

    public boolean cadastrarMusica(Musica musica) {
        if (musica == null) {
            return false;
        }
        acervo.add(musica);
        totalMusicas++;
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        usuarios.add(usuario);
        totalUsuarios++;
        return true;
    }

    public Musica buscarMusicaPorId(int id) {
        for (int i = 0; i < totalMusicas; i++) {
            if (acervo.get(i).getId() == id) {
                return acervo.get(i);
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (int i = 0; i < totalMusicas; i++) {
            if (acervo.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return acervo.get(i);
            }
        }
        return null;
    }

    public int getTotalMusicas() {
        return totalMusicas;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public Usuario getUsuarioPorId(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id)
                return usuario;
        }
        throw new IllegalStateException("Usuário com id " + id + " não cadastrado!");
    }

}