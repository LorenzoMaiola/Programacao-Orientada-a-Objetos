package Lista02.EX03;

public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;

    public ContaBancaria(String numero, String titular, double saldo) {
        setNumero(numero);
        setTitular(titular);
        this.saldo = saldo;
    }

    public ContaBancaria(){

    }


    public void sacar(double valor) {
        if (valor < 0) {
            System.out.println("Não é possível sacar valores negativos");
            return;
        }
        if ((saldo < valor)) {
            System.out.println("Não é possível realizar saques de um valor maior que o saldo!");
        }

        saldo -= valor;
    }

    public void depositar(double valor){
        if(valor < 0){
            System.out.println("Não é possível realizar depósitos de quantidades negativas");
            return;
        }

        saldo += valor;
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        this.saldo -= valor;
        contaDestino.depositar(valor);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

}
