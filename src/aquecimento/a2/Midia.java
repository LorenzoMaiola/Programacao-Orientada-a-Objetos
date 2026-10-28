package aquecimento.a2;

public abstract class Midia {
    private String descricao;
    private double precoBase;

    public Midia(String descricao, double precoBase){
        setDescricao(descricao);
        setPrecoBase(precoBase);
    }
    
    abstract double calcularPreco();
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
    
}
