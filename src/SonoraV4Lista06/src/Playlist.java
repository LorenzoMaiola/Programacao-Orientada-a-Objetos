import java.util.ArrayList;

public class Playlist {
    private static final int CAPACIDADE_MAXIMA = 100;

    private String nome;
    private Usuario dono;
    private ArrayList<Musica> musicas;
    private int quantidade;

    public Playlist(String nome, Usuario dono) {
        setNome(nome);
        setDono(dono);
        this.musicas = new ArrayList<>();
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome.isBlank() || nome.isEmpty())
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        this.nome = nome;
    }

    public Usuario getDono() {
        return dono;
    }

    private void setDono(Usuario dono) {
        if (dono == null)
            throw new IllegalArgumentException("A playlist deve ter um dono!");
        this.dono = dono;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Musica getNaPosicao(int indice) {
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Insira um índice inválido! Se atente ao tamanho da playlist");
        }
        return musicas.get(indice);
    }

    public int getDuracaoTotalSegundos() {
        int total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += musicas.get(i).getDuracaoSegundos();
        }
        return total;
    }

    public boolean adicionar(Musica musica) {
        if (quantidade >= CAPACIDADE_MAXIMA) {
            return false;
        } else if (musica == null) {
            throw new IllegalArgumentException("É necessário informar uma música para adicionar à playlist");
        }
        musicas.add(musica);
        quantidade++;
        return true;
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Insira um índice inválido! Se atente ao tamanho da playlist");
        }
        musicas.remove(indice);
        quantidade--;
        return true;
    }

    public void reproduzirTudo() {
        for (int i = 0; i < quantidade; i++) {
            musicas.get(i).reproduzir();
        }
    }
}