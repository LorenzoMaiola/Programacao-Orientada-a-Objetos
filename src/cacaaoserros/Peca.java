package cacaaoserros;

public class Peca extends ItemSetup {
    private final int quantidade;

    public Peca(String descricao, double precoBase, int quantidade) {
        super(descricao, precoBase);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.quantidade = quantidade;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * quantidade;
    }
}
