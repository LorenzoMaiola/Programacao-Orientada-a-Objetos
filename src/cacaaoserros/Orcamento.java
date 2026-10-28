package cacaaoserros;

import java.util.ArrayList;
import java.util.List;

public class Orcamento {
    private final Solicitante solicitante;
    private final List<ItemSetup> itens = new ArrayList<>();

    public Orcamento(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public List<ItemSetup> getItens() {
        return itens;
    }

    public void adicionarItem(ItemSetup item) {
        // A ordem exigida é: null, repetido, limite.
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
}
