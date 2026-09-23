package SonoraV5Lista08.src;

public class Podcast extends Conteudo {

    private Usuario apresentador;
    private int numeroEpisodio;

    public Podcast(String titulo, int duracaoSegundos, Usuario apresentador, int numeroEpisodio) {
        super(titulo, duracaoSegundos);
        setApresentador(apresentador);
        setNumeroEpisodio(numeroEpisodio);
    }

    public Usuario getApresentador() {
        return apresentador;
    }

    public void setApresentador(Usuario apresentador) {
        this.apresentador = apresentador;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        if (numeroEpisodio <= 0)
            throw new IllegalArgumentException("Número de episódio inválido!");
        this.numeroEpisodio = numeroEpisodio;

    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + getTitulo()
                + " (" + getDuracaoSegundos() + "s)"
                + "Apresentado por: " + getApresentador()
                + "Episódio: " + getNumeroEpisodio();
    }

}
