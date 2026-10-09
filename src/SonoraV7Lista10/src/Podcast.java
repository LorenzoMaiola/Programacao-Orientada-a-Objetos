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
        if (apresentador == null)
            throw new IllegalArgumentException("O podcast precisa de um apresentador!");
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
        return super.toString() + " | Apresentado por: "
                + getApresentador().getNome()
                + " | Episódio: " + getNumeroEpisodio();
    }

    @Override
    public String getCreditos() {
        return "Episódio " + getNumeroEpisodio() + ", apresentado por " + getApresentador().getNome();
    }

    //metodo da interface
    @Override
    public String duracaoFormatada() {

        int minutos = getDuracaoSegundos() / 60;
        int segundos = getDuracaoSegundos() % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
}