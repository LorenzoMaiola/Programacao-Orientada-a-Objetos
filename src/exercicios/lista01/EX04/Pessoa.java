package exercicios.lista01.EX04;
public class Pessoa{

    Pessoa(String nome, double altura, double peso){
        this.nome = nome;
        this.altura = altura;
        this.peso= peso;
    }
    
    String nome;
    double altura;
    double peso;

    double calcularImc(){
        return this.peso / (this.altura * this.altura);
    }

    void imprimirImc(){
        System.out.printf("Imc = %d", calcularImc());
    }
}