package aquecimento.a2;

import java.util.ArrayList;
//upcasting aumenta a abstracao do codigo, facilitando a manutencao do mesmo.
//R: não, nao entrou no total.Como o calculo esta dentro de if (m instanceof Serie), Documento nao e do tipo Serie, entao nao entra no if e o calculo nao e realizado. 

public class Main {
    public static void main(String[] args) {
        Midia f = new Filme("Interestelar", 20.0);
        Midia s = new Serie("Dark", 15.0, 3);
        Midia d = new Documentario("Documentário da netflix", 10);
        ArrayList<Midia> catalogo = new ArrayList<>();
        catalogo.add(f);
        catalogo.add(s);
        catalogo.add(d);
        double totalLegenda = 0;
        for (Midia m : catalogo) {
            if (m instanceof Legendavel) {
                totalLegenda += ((Legendavel) m).calcularCustoLegenda();
            }
        }
        System.out.println(totalLegenda);
    }
}
