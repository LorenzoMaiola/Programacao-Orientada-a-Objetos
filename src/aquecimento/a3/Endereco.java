package aquecimento.a3;

public class Endereco {
    private String rua;
    private int numero;

    public Endereco(String rua, int numero) {
        setNumero(numero);
        setRua(rua);
    }

    public Endereco(){}

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
