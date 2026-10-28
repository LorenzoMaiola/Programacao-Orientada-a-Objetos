package aquecimento.a2;

public class Serie extends Midia implements Legendavel{
    private int temporadas;

    public Serie(String descricao, double precoBase, int temporadas) {
        super(descricao, precoBase);
        setTemporadas(temporadas);
    }

    
    @Override
    double calcularPreco() {
        return getPrecoBase() * temporadas;
    }
    
    
        public int getTemporadas() {
            return temporadas;
        }
    
        public void setTemporadas(int temporadas) {
            this.temporadas = temporadas;
        }


        @Override
        public double calcularCustoLegenda() {
            return calcularPreco() * 0.10;
        }
}
