package setup.setup;

public abstract class ItemSetup {
    private static int totalItens = 0;

    private int codigo;
    private String descricao;
    private double precoBase;

    public ItemSetup(String descricao, double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("Preço base inválido");
        }

        // O contador só é incrementado depois de validar o preço-base.
        totalItens++;
        this.codigo = totalItens;
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public static int getTotalItens() {
        return totalItens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();

    @Override
    public String toString() {
        return codigo + " - " + descricao + " - R$ " + calcularPreco();
    }
}
