package delivery;
public abstract class ItemCardapio{
    private static int totalItens = 1;
    
    private int codigo = totalItens;
    private String descricao;
    private double precoBase;
    
    public ItemCardapio(String descricao, double precoBase){
        totalItens++;
        if(precoBase <= 0)
            throw new IllegalArgumentException("Preço base inválido");
        this.precoBase = precoBase;
        this.descricao = descricao;
    }
    
    public static int getTotalItens() {
        return totalItens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();
    
    public String toString() {
        return getCodigo() + " - " + getDescricao() + " - " + "R$" + calcularPreco(); 
    }

}