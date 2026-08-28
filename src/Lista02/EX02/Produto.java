package Lista02.EX02;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        this.estoque = estoque;
    }

    public void vender(int quantidade) {
        if (estoque <= 0) {
            System.out.println("Não é possível vender um produto sem tê-lo no estoque!");
        } else {
            estoque -= quantidade;
        }
    }

    public void repor(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Não é possível repor uma quantidade negativa do produto");
        }
        else{
            estoque += quantidade;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            System.out.println("O preço do produto deve ser maior que zero!");
        } else {
            this.preco = preco;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

}
