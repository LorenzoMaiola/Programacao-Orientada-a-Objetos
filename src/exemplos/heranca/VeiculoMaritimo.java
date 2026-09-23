package exemplos.heranca;

public class VeiculoMaritimo extends Veiculo{
    public VeiculoMaritimo(){
        super(20);
    }

    @Override 
	public void printVeiculo(){
		System.out.println("veículo: "+getAnoFabricacao()+getMarca()+getModelo()+getValor());
	}

}
