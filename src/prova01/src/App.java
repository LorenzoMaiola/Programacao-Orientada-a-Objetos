package prova01.src;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //--Sobrecarga--
        Produto mouse = new Produto(1234, "mouse");
        Produto teclado = new Produto(4321, "teclado", 10);

        //operações válidas
        mouse.adicionar(10);
        mouse.getCodigo();
        mouse.getNome();
        mouse.remover(10);
        mouse.getQuantidade(); //0(10-10)
        mouse.setNome("novoMouse");
        
        teclado.adicionar(10);
        teclado.getCodigo();
        teclado.getNome();
        teclado.remover(20);
        teclado.getQuantidade(); //8(20-20)
        teclado.setNome("novoTeclado");
        

        try {
            teclado.remover(-1);//IllegalArgument
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            teclado.remover(3);//IllegalState

        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
        
        try {
            teclado.adicionar(-1);//IllegalArgument

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Produto mouseInvalido = new Produto(12, "mouse negativo", -1);//IllegalArgument

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        finally{
            int produtosCriados = Produto.totalProdutos;
            System.out.printf("%d produtos foram criados!", produtosCriados);
            Produto.totalProdutos = 0;
        }
    }
}
