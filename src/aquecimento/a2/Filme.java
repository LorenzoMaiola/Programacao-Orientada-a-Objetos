package aquecimento.a2;

public class Filme extends Midia{

    public Filme(String descricao, double precoBase) {
        super(descricao, precoBase);
    }

    @Override
    double calcularPreco() {
        return getPrecoBase();
    }
    
}
