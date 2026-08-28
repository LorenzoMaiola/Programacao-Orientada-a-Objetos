package Lista02.EX02;

public class App {
    public static void main(String[] args) {
        Produto produto = new Produto("Parafuso", 2, 10);

        produto.vender(2);
        
        System.out.printf("Venda realizada! Agora, tem %d %s(s) em estoque\n", produto.getEstoque(), produto.getNome());
        
        produto.setPreco(-1);

        produto.repor(12);

        System.out.printf("Reposição feita! Agora tem %d %s(s) em estoque\n", produto.getEstoque(), produto.getNome());

        produto.repor(-12);

    }
}
