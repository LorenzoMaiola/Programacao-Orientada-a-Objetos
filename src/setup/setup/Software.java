package setup.setup;

public class Software extends ItemSetup implements ComGarantia {
    private int licencas;

    public Software(String descricao, double precoBase, int licencas) {
        super(descricao, precoBase);
        if (licencas <= 0) {
            throw new IllegalArgumentException("Quantidade de licenças inválida");
        }
        this.licencas = licencas;
    }

    public int getLicencas() {
        return licencas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * licencas;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return calcularPreco() * 0.15;
    }
}
