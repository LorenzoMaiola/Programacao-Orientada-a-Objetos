public class Produto {
    private int codigo;
    private String nome;
    private int quantidade;
    static int totalProdutos;

    public Produto(int codigo, String nome){
        setCodigo(codigo);
        setNome(nome);
        this.quantidade = 0;
        totalProdutos ++;
    }

    public Produto(int codigo, String nome, int quantidadeInicial){
        setQuantidade(quantidadeInicial);    
        setCodigo(codigo);
        setNome(nome);
        totalProdutos ++;
    }

    public void adicionar(int qtd){
        if(qtd <= 0)
            throw new IllegalArgumentException("Quantidade de entrada inválida");//testado
        
        quantidade += qtd;
    }

    public void remover(int qtd){
        if(qtd <= 0)
            throw new IllegalArgumentException("Quantidade de saída inválida");//testado
        
        if(qtd > this.getQuantidade())
            throw new IllegalStateException("Estoque insuficiente");//testado
        
        quantidade -= qtd;
    }

//setter usado apenas no construtor, por isso private
private void setCodigo(int codigo){
    this.codigo = codigo;
}

public int getCodigo(){
    return this.codigo;
}

public void setNome(String nome){
    this.nome = nome;
}

public String getNome(){
    return this.nome;
}

//setter usado apenas no construtor, por isso private
private void setQuantidade(int quantidadeInicial){
    if(quantidadeInicial < 0)
        throw new IllegalArgumentException("Quantidade inicial inválida");//testado
    this.quantidade = quantidadeInicial;
}

public int getQuantidade(){
    return this.quantidade;
}

}