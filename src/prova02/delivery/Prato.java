package delivery;
public class Prato extends ItemCardapio {

    private int quantidade;

    public Prato(String descricao, double precoBase, int quantidade) {
        super(descricao, precoBase);
        if(quantidade <= 0)
            throw new IllegalArgumentException("Quantidade de pratos inválida");
        this.quantidade = quantidade;
    }

    
    public int getQuantidade() {
        return quantidade;
    }
    
    @Override
    public double calcularPreco() {
        return getPrecoBase() * quantidade;
    }
}
