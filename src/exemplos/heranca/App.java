package SonoraV5Lista08;

import exemplos.heranca.Veiculo;
import exemplos.heranca.VeiculoAereo;
import exemplos.heranca.VeiculoTerrestre;

public class App {
    public static void main(String[] args) {
        Veiculo v = new Veiculo(50000);
        v.setAnoFabricacao(1988);   
        v.setMarca("BYD"); 
        v.setModelo("Dolphin");
        v.printVeiculo();

        VeiculoAereo va = new VeiculoAereo();
        va.setAnoFabricacao(2023);
        va.setMarca("Embraer");
        va.setModelo("seila");
        va.printVeiculo();

        
        VeiculoTerrestre vt = new VeiculoTerrestre();
        vt.setAnoFabricacao(2026);
        vt.setMarca("Jeep");
        vt.setModelo("Rampage");
        vt.printVeiculo();

    }
}
