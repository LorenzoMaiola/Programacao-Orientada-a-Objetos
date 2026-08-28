package Lista01.EX02;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.println("Insira sua altura: ");
        pessoa.altura = sc.nextDouble();

        System.out.println("Insira seu peso: ");
        pessoa.peso = sc.nextDouble();

        double imcPessoa = pessoa.calcularImc();
        System.out.println("Seu imc é: " + imcPessoa);
        sc.close();
    }
}
