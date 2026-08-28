package exercicios.lista01.EX03;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        Pessoa pessoa3 = new Pessoa();

        System.out.println("Insira a altura da primeira pessoa: ");
        pessoa1.altura = sc.nextDouble();

        System.out.println("Insira o peso da primeira pessoa: ");
        pessoa1.peso = sc.nextDouble();

        double imcPessoa1 = pessoa1.calcularImc();


        System.out.println("Insira a altura da segunda pessoa: ");
        pessoa2.altura = sc.nextDouble();

        System.out.println("Insira o peso da segunda pessoa: ");
        pessoa2.peso = sc.nextDouble();

        double imcPessoa2 = pessoa2.calcularImc();

        System.out.println("Insira a altura da terceira pessoa: ");
        pessoa3.altura = sc.nextDouble();

        System.out.println("Insira o peso da terceira pessoa: ");
        pessoa3.peso = sc.nextDouble();

        double imcPessoa3 = pessoa3.calcularImc();
        
        System.out.println("O peso da pessoa 1 é: " + imcPessoa1);

        System.out.println("O peso da pessoa 2 é: " + imcPessoa2);

        System.out.println("O peso da pessoa 3 é: " + imcPessoa3);
        sc.close();
    }
}