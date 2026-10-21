package delivery;
import java.util.ArrayList;

public class Pedido {
    private Cliente comprador;
    private ArrayList<ItemCardapio> itens;
    private Endereco entrega;

    public Pedido(Cliente comprador, String rua, int numero) {
        entrega = new Endereco(rua, numero);
        itens = new ArrayList<>();
        setComprador(comprador);
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        if (comprador == null) {
            throw new IllegalArgumentException("Comprador obrigatório");
        }

        this.comprador = comprador;
    }

    public String getRuaEntrega() {
        return entrega.getRua();
    }

    public int getNumeroEntrega() {
        return entrega.getNumero();
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public void adicionarItens(ItemCardapio i) {
        if (i == null)
            throw new IllegalArgumentException("Item inválido");

        for (ItemCardapio itemCardapio : itens) {
            if (i == itemCardapio)
                throw new IllegalStateException("Item já incluído no pedido");
        }

        if (itens.size() == 8)
            throw new IllegalStateException("Pedido lotado");
    
        itens.add(i);
        }

    public void removerItem(ItemCardapio i) {
        for (ItemCardapio itemCardapio : itens) {
            if (itemCardapio == i) {
                itens.remove(itemCardapio);
                return;
            }
        }
        throw new IllegalStateException("Item não encontrado no pedido");

    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (ItemCardapio itemCardapio : itens) {
            valorTotal += itemCardapio.calcularPreco();
        }

        return valorTotal;
    }

    public double calcularTotalImpostos() {
        double totalImposto = 0;
        for (ItemCardapio itemCardapio : itens) {
            if (itemCardapio instanceof Bebida) {
                totalImposto += ((Bebida) itemCardapio).CalcularImposto();

            }

        }
        return totalImposto;
    };

}
