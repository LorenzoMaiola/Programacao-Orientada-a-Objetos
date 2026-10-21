package delivery;
public class Bebida extends ItemCardapio implements Tributavel {
    
    private int unidades;

    public Bebida(String descricao, double precoBase, int unidades) {
        super(descricao, precoBase);
        if (unidades <= 0)
            throw new IllegalArgumentException("Quantidade de unidades inválida");
        this.unidades = unidades;
    }


    
    public int getUnidades() {
        return unidades;
    }
    
    @Override
    public double calcularPreco() {
        if (getUnidades() >= 6) {
            double desconto = 0.15;
            double precoNormal = getPrecoBase() * unidades;
            return precoNormal - (precoNormal * desconto);
        }
        
        return getPrecoBase() * unidades;
    }
    
    @Override
    public double CalcularImposto() {
        return (calcularPreco() * 0.12);
    }
    
}
