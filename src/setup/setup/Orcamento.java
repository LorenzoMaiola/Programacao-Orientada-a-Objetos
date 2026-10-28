package setup.setup;

import java.util.ArrayList;

public class Orcamento {
    private Cliente solicitante;
    private Entrega entrega;
    private ArrayList<ItemSetup> itens = new ArrayList<>();

    public Orcamento(Cliente solicitante, String cidade, int prazoDias) {
        setSolicitante(solicitante);
        this.entrega = new Entrega(cidade, prazoDias);
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Cliente solicitante) {
        if (solicitante == null) {
            throw new IllegalArgumentException("Solicitante obrigatório");
        }
        this.solicitante = solicitante;
    }

    public String getCidadeEntrega() {
        return entrega.getCidade();
    }

    public int getPrazoEntrega() {
        return entrega.getPrazoDias();
    }

    public ArrayList<ItemSetup> getItens() {
        return itens;
    }

    public void adicionarItem(ItemSetup item) {
        if (item == null) {
            throw new IllegalArgumentException("Item inválido");
        }
        if (itens.contains(item)) {
            throw new IllegalStateException("Item já incluído no orçamento");
        }
        if (itens.size() >= 5) {
            throw new IllegalStateException("Orçamento lotado");
        }
        itens.add(item);
    }

    public void removerItem(ItemSetup item) {
        if (!itens.remove(item)) {
            throw new IllegalStateException("Item não encontrado no orçamento");
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemSetup item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }

    public double calcularTotalGarantia() {
        double total = 0;
        for (ItemSetup item : itens) {
            if (item instanceof ComGarantia) {
                // Usamos a interface, não Peca, porque qualquer classe que
                // implemente ComGarantia (por exemplo, Software) deve contar.
                total += ((ComGarantia) item).calcularGarantiaEstendida();
            }
        }
        return total;
    }
}
