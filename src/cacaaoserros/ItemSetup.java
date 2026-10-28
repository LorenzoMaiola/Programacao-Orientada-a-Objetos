package cacaaoserros;

public abstract class ItemSetup {
    private static int totalItens = 0;

    private final int codigo;
    private final String descricao;
    private final double precoBase;

    public ItemSetup(String descricao, double precoBase) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição inválida");
        }
        if (precoBase <= 0) {
            throw new IllegalArgumentException("Preço base inválido");
        }

        totalItens++;
        this.codigo = totalItens;
        this.descricao = descricao;
        this.precoBase = precoBase;
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
        return codigo + " - " + descricao
                + " - R$ " + String.format("%.2f", calcularPreco());
    }
}
