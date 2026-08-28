package exemplos.construtores;

public class Carro {

    private String modelo;
    private int ano;
    private String cor;
    private boolean documentoEmDia;
    private String marca;

    public Carro(String modelo, int ano, String cor) {
        this();// isso faz com que o construtor abaixo, seja chamado dentro do construtor,
               // assim, documentoEmDia será true nos dois. Se precisar mudar, muda apenas no
               // abaixo
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public Carro() {
        documentoEmDia = true;
    }

    public Carro(String modelo, int ano, String cor, String marca) {
        this("Honda", ano, cor);// chama o primeiro construtor, assim não precisa repetir tudo. tambem permite
                                // deixar fixo valores, como o "Honda".
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isDocumentoEmDia() {
        return documentoEmDia;
    }

    public void setDocumentoEmDia(boolean documentoEmDia) {
        this.documentoEmDia = documentoEmDia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
