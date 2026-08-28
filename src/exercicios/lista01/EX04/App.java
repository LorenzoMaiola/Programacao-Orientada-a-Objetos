package exercicios.lista01.EX04;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>(3);    
        
        for(int i = 0; i < 3; i++){
            System.out.printf("Insira o nome da pessoa %d :", i + 1);
            String nome = sc.next();

            System.out.printf("Insira a altura da pessoa %d: ", i + 1);
            double altura = sc.nextDouble();

            System.out.printf("Insira o peso da pessoa %d: ", i + 1);
            double peso = sc.nextDouble();
        
            pessoas.add(new Pessoa(nome,altura,peso));
            
        }

        for(int i = 2; i >= 0; i--){
            double imc = pessoas.get(i).calcularImc();
            System.out.printf("O imc da pessoa %d é: %f", i + 1, imc);
            System.out.println();
        }
        
        sc.close();
    }
}