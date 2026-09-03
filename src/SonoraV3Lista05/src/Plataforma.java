public class Plataforma {
    private static final int CAPACIDADE_MAXIMA = 500;

    private Musica[] acervo;
    private int totalMusicas;

    private Usuario[] usuarios;
    private int totalUsuarios;

    public Plataforma() {
        this.acervo = new Musica[CAPACIDADE_MAXIMA];
        this.totalMusicas = 0;
        this.usuarios = new Usuario[CAPACIDADE_MAXIMA];
        this.totalUsuarios = 0;
    }

    public boolean cadastrarMusica(Musica musica) {
        if (musica == null || totalMusicas >= CAPACIDADE_MAXIMA) {
            return false;
        }
        acervo[totalMusicas] = musica;
        totalMusicas++;
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null || totalUsuarios >= CAPACIDADE_MAXIMA) {
            return false;
        }
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
        return true;
    }

    public Musica buscarMusicaPorId(int id) {
        for (int i = 0; i < totalMusicas; i++) {
            if (acervo[i].getId() == id) {
                return acervo[i];
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (int i = 0; i < totalMusicas; i++) {
            if (acervo[i].getTitulo().equalsIgnoreCase(titulo)) {
                return acervo[i];
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
}