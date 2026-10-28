package aquecimento.b;

public class Erros {
    /*
     * B1. Limite
     * if (itens.size() > 5) {
     * throw new IllegalStateException("Orçamento lotado");
     * }
     * itens.add(item);
     * R:Se o máximo é 5 itens, deveria ser >=5. Do jeito que está deixa adicionar um sexto item
     * 
     * 
     * B2. Tipo da exceção
     * if (itens.contains(item)) {
     * throw new IllegalArgumentException("Item já incluído no orçamento");
     * }
     * 
     * 
     * 
     * B3. Ordem das validações
     * if (item == null) throw new IllegalArgumentException("Item inválido");
     * if (itens.size() == 5) throw new IllegalStateException("Orçamento lotado");
     * if (itens.contains(item)) throw new
     * IllegalStateException("Item já incluído no orçamento");
     * O enunciado pede null, depois repetido, depois lotado. Monte o cenário em que
     * esta versão devolve a mensagem
     * errada.
     * 
     * 
     * 
     * 
     * B4. Remoção
     * public void removerItem(ItemSetup item) {
     * for (ItemSetup i : itens) {
     * if (i != item) {
     * throw new IllegalStateException("Item não encontrado no orçamento");
     * }
     * }
     * itens.remove(item);
     * }
     * 
     * 
     * 
     * 
     * 
     * B5. Contador
     * public ItemSetup(String descricao, double precoBase) {
     * totalItens++;
     * codigo = totalItens;
     * if (precoBase <= 0) {
     * throw new IllegalArgumentException("Preço base inválido");
     * }
     * this.descricao = descricao;
     * this.precoBase = precoBase;
     * }
     * 
     * B6. Base do cálculo
     * 
     * @Override
     * public double calcularGarantiaEstendida() {
     * return getPrecoBase() * quantidade * 0.15;
     * }
     * 
     * 
     * 
     * 
     * B7. toString sem @Override
     * public String tostring() {
     * return getCodigo() + " - " + getDescricao() + " - R$ " + calcularPreco();
     * }
     * Rode System.out.println(item). O que aparece? Coloque @Override em cima do
     * método e compile. O que o
     * compilador diz? Explique por que @Override vale também para métodos herdados
     * de Object, e não só para métodos
     * abstratos ou de interface.
     * 
     * 
     * 
     * 
     * 
     * B8. main
     * Peca placa = new Peca("Placa de vídeo", 2500.0, 1);
     * orcamento.adicionarItem(placa);
     * System.out.println("Solicitante: " + orcamento.getSolicitante());
     * System.out.println(orcamento.getItens());
     * orcamento.adicionarItem(placa);
     * 
     * 
     * 
     */
}