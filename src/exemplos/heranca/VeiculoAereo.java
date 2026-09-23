package exemplos.heranca;

public class VeiculoAereo extends Veiculo {
    public VeiculoAereo(){
        super(30);
    }

    @Override 
	public void printVeiculo(){
		System.out.println("veículo: "+getAnoFabricacao()+getMarca()+getModelo()+getValor());
	}
}
