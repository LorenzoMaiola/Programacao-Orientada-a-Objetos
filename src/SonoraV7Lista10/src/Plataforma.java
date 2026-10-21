import java.util.ArrayList;

public class Plataforma {

    private int totalMusicas;
    private ArrayList<Conteudo> acervo;
    private int totalPodcasts;
    private ArrayList<Usuario> usuarios;
    private int totalUsuarios;

    public Plataforma() {
        this.totalMusicas = 0;
        this.usuarios = new ArrayList<>();
        this.totalUsuarios = 0;
        this.acervo = new ArrayList<>();
        this.totalPodcasts = 0;
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

    public Conteudo buscarMusicaPorId(int id) {
        for (int i = 0; i < totalMusicas; i++) {
            if (acervo.get(i).getId() == id) {
                return acervo.get(i);
            }
        }
        return null;
    }

    public Conteudo buscarMusica(String titulo) {
        for (int i = 0; i < totalMusicas; i++) {
            if (acervo.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return acervo.get(i);//assim funciona ou preciso fazer cast de Musica?
            }
        }
        return null;
    }

    //nao sei o que tenho que fazer aqui
    // public List<Musica> getMusicas() {
    //     return new ArrayList<>(conteudos);
    // }

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

    
    public boolean cadastrarPodcast(Podcast podcast) {
        if (podcast == null) {
            return false;
        }
        acervo.add(podcast);
        totalPodcasts++;
        return true;
    }

    public Conteudo getPodcastPorId(int id) {
        for (int i = 0; i < acervo.size(); i++) {
            Conteudo podcast = (Podcast)acervo.get(i);//esta certo assim?
            if (acervo.get(i).getId() == id)
                return podcast;
        }
        throw new IllegalStateException("Podcast com id " + id + " não cadastrado!");
    }

    public int getTotalPodcasts(){
        return totalPodcasts;
    }
}
