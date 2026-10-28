package cacaaoserros;

public class Monitor extends ItemSetup {
    private final int quantidade;

    public Monitor(String descricao, double precoBase, int quantidade) {
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

    public double calcularGarantiaEstendida() {
        return calcularPreco() * 0.15;
    }
}
