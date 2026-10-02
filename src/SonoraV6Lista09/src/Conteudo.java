public abstract class Conteudo {
    private static int contador = 0;
    private String titulo;
    private int duracaoSegundos;
    private int id;
    private int reproducoes;

    public Conteudo(String titulo, int duracaoSegundos) {
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
        this.id = ++contador;
        this.reproducoes = 0;
    }

    public abstract String getCreditos();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank())
            throw new IllegalArgumentException("O título não pode ser vazio!");

        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0)
            throw new IllegalArgumentException("A duração deve ser maior que zero!");

        this.duracaoSegundos = duracaoSegundos;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public final void reproduzir() {
        reproducoes++;
        System.out.println("Reproduzindo: " + titulo + " - " + getCreditos());
    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + titulo
                + " (" + duracaoSegundos + "s)";
    }

}
