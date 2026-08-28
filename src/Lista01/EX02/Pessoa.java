package Lista01.EX02;
public class Pessoa{

    double altura;
    double peso;

    double calcularImc(){
        return peso / (altura * altura);
    }
}
