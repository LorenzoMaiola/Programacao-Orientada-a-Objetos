package SonoraV5Lista08.src;

public class Podcast extends Conteudo {

    private Usuario apresentador;
    private int numeroEpisodio;
    private int reproducoes;

    public Podcast(String titulo, int duracaoSegundos, Usuario apresentador, int numeroEpisodio) {
        super(titulo, duracaoSegundos);
        setApresentador(apresentador);
        setNumeroEpisodio(numeroEpisodio);
        this.reproducoes = 0;
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

    public int getReproducoes(){
        return reproducoes;
    }

    @Override 
    public void reproduzir(){
        super.reproduzir();
        reproducoes++;
    }

    @Override
    public String toString() {
        return super.toString() + "Apresentado por: "
                + getApresentador().getNome()
                + "Episódio: " + getNumeroEpisodio();
    }

}
