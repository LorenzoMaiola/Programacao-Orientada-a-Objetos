package Lista01.EX03;
public class Pessoa{

    double altura;
    double peso;

    double calcularImc(){
        return peso / (altura * altura);
    }
}