package SonoraV3Lista05.src;

public class Musica {
    private static int contador = 0;

    private final int id;
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int reproducoes;

    public Musica(String titulo, String artista, int duracaoSegundos) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        this.id = ++contador;
        this.reproducoes = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        if (titulo.isEmpty() || titulo.isBlank())
            throw new IllegalArgumentException(" O título não pode ser vazio!");
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    private void setArtista(String artista) {
        if (artista.isBlank() || artista.isEmpty()) {
            throw new IllegalArgumentException(" O artista não pode ser vazio");
        }
        this.artista = artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    private void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0)
            throw new IllegalArgumentException(" A música deve ter alguma duração! " + duracaoSegundos + " segundos não é um tempo válido!");
        this.duracaoSegundos = duracaoSegundos;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public void reproduzir() {
        reproducoes++;
    }

    public String getDuracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
}