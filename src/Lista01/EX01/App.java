package Lista01.EX01;
public class App {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.altura = 1.75;
        pessoa.peso = 78;
        
        double imcPessoa = pessoa.calcularImc();
        System.out.println("O imc da pessoa é: " + imcPessoa);
    }
}
