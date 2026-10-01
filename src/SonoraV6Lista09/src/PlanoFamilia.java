public class PlanoFamilia extends PlanoPago {

    private int quantidadeMembros;

    public PlanoFamilia(String nome, int maxDispositivos, double precoMensal, int quantidadeMembros) {
        super(nome = "Família", maxDispositivos = 6, precoMensal);
        setQuantidadeMembros(maxDispositivos);
    }

    public int getQuantidadeMembros() {
        return quantidadeMembros;
    }

    public void setQuantidadeMembros(int quantidadeMembros) {
        if(quantidadeMembros < 1 || quantidadeMembros > 6)
            throw new IllegalArgumentException("Membros deve ser de 1 a 6"); 
        this.quantidadeMembros = quantidadeMembros;
    }

    @Override
    public double calcularMensalidade() {
        // TODO Auto-generated method stub
        return super.calcularMensalidade() + 4.90 * (quantidadeMembros - 1);
    }

    @Override
    public String resumo() {
        return super.resumo();
    }
}
