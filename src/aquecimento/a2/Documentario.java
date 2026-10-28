package aquecimento.a2;

public class Documentario extends Midia implements Legendavel{

    public Documentario(String descricao, double precoBase) {
        super(descricao, precoBase);
        
    }

    @Override
    double calcularPreco() {
        return getPrecoBase();
    }

    @Override
    public double calcularCustoLegenda() {
        return calcularPreco() * 0.10;
    }
    
}
