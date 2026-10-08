public abstract class Plano {
    private String nome;
    private int maxDispositivos;

    public Plano(String nome, int maxDispositivos) {
        setNome(nome);
        setMaxDispositivos(maxDispositivos);
    }

    public abstract boolean temAnuncios();

    public abstract double calcularMensalidade();

    public final String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome do plano não pode ser vazio!");
        this.nome = nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

    private void setMaxDispositivos(int maxDispositivos) {
        if (maxDispositivos < 1)
            throw new IllegalArgumentException("O plano deve permitir ao menos 1 dispositivo!");
        this.maxDispositivos = maxDispositivos;
    }

}
