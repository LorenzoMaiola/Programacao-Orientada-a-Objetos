//R: classe vazia, mas continua tendo um significado importante para o sistema, logo, deve ficar. 
public class PlanoIndividual extends PlanoPago {

    public PlanoIndividual(double precoMensal) {
        super("Individual", 1, precoMensal);
    }

    @Override
    public double calcularMensalidade() {
        return getPrecoMensal();
    }
}
