public class PlanoPago extends Plano{
    private double precoMensal;


    public PlanoPago(String nome, int maxDispositivos, double precoMensal){
        super(nome, maxDispositivos);
        setPrecoMensal(maxDispositivos);
    }
    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        if(precoMensal <= 0 )
            throw new IllegalArgumentException("Preço do plano pago deve ser maior que zero!");
        this.precoMensal = precoMensal;
    }       

    @Override
    public boolean temAnuncios() {
        return false;
    }

    @Override
    public double calcularMensalidade() {
        return precoMensal;
    }

}
