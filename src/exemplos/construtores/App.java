package exemplos.construtores;

public class App {
    public static void main(String[] args) {

        Carro carro1 = new Carro("Gol", 2020, "Azul");

        System.out.println(carro1.getModelo());


        Carro carro2 = new Carro();
        //printa null, nenhum valor dado aos atributos
        System.out.println(carro2.getModelo());
    }
}