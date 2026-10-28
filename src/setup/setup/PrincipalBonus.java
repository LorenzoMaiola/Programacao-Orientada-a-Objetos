package setup.setup;

public class PrincipalBonus {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Marina Souza", "123.456.789-00");
        Orcamento orcamento = new Orcamento(cliente, "Blumenau", 7);

        ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
        ItemSetup monitor = new Peca("Monitor 27 polegadas", 1200.0, 3);
        ItemSetup montagem = new Montagem("Montagem e cabeamento", 80.0, 2);
        ItemSetup sistema = new Software("Sistema operacional", 300.0, 2);

        orcamento.adicionarItem(placa);
        orcamento.adicionarItem(monitor);
        orcamento.adicionarItem(montagem);
        orcamento.adicionarItem(sistema);

        for (ItemSetup item : orcamento.getItens()) {
            System.out.println(item);
        }
        System.out.println("Valor total: R$ " + orcamento.calcularValorTotal());
        System.out.println("Garantia estendida: R$ " + orcamento.calcularTotalGarantia());

    }
}
