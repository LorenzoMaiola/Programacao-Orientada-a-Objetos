public class Musica extends Conteudo {
    private String artista;
    private String album;

    public Musica(String titulo, int duracaoSegundos, String album, String artista) {
        super(titulo, duracaoSegundos);
        setArtista(artista);
        setAlbum(album);
    }

    public String getArtista() {
        return artista;
    }

    private void setArtista(String artista) {
        if (artista == null || artista.isBlank()) {
            throw new IllegalArgumentException("O artista não pode ser vazio");
        }
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return super.toString() + " | Álbum: " + getAlbum() + " - " + getArtista();
    }

    @Override
    public String getCreditos() {
        return getArtista() + " (" + getAlbum() + ")";
    }

    //metodo da interface
    @Override
    public String duracaoFormatada() {
        int minutos = getDuracaoSegundos() / 60;
        int segundos = getDuracaoSegundos() % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
}
