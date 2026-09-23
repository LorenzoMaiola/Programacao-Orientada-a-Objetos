package exemplos.heranca;

public class VeiculoTerrestre extends Veiculo{
    public VeiculoTerrestre(){
        super(10);
    }

    
    @Override 
	public void printVeiculo(){
		System.out.println("veículo: "+getAnoFabricacao()+getMarca()+getModelo()+getValor());
	}   


}
