package exemplos.sobrecarga;

public class Calculadora {

    public static void Somar(int valor1, int valor2) {
        int soma = valor1 + valor2;
        System.out.println("O resultado da soma é: " + soma);
    }

    /*
     * Isso daria erro, assinaturas iguais
     * public static int Somar(int valor1, int exemplo)
     * {
     * return 0;
     * }
     */

    // isso nao da erro, assinaturas diferentes
    public static void Somar(int valor1, int valor2, int valor3) {
        int soma = valor1 + valor2 + valor3;
        System.out.println("O resultado da soma é: " + soma);
    }

}