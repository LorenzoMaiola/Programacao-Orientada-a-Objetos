public abstract class Plano {
    private String nome;
    private int maxDispositivos;

    public Plano(String nome, int maxDispositivos) {
        this.nome = nome;
        this.maxDispositivos = maxDispositivos;
    }

    public abstract boolean temAnuncios();

    public abstract double calcularMensalidade();

    public String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
    
    public String getNome() {
        return nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

}