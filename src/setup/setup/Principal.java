package setup.setup;

public class Principal {
    public static void main(String[] args) {
        
        // O contador termina em 4, e não 3, porque a Montagem inválida chama
        // super(...) antes de validar horas. O construtor de ItemSetup valida
        // precoBase e incrementa o contador; depois, Montagem detecta horas <= 0.
        // Em A1(c), a validação do preço-base ocorre na própria superclasse antes
        // do incremento, então um preço-base inválido não consome código.
        System.out.println("Itens criados: " + ItemSetup.getTotalItens());


        Cliente cliente = new Cliente("Marina Souza", "123.456.789-00");
        Orcamento orcamento = new Orcamento(cliente, "Blumenau", 7);

        ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
        ItemSetup monitor = new Peca("Monitor 27 polegadas", 1200.0, 3);
        ItemSetup montagem = new Montagem("Montagem e cabeamento", 80.0, 2);

        orcamento.adicionarItem(placa);
        orcamento.adicionarItem(monitor);
        orcamento.adicionarItem(montagem);

        System.out.println("Solicitante: " + orcamento.getSolicitante().getNome());
        System.out.println("Entrega: " + orcamento.getCidadeEntrega()
                + ", em " + orcamento.getPrazoEntrega() + " dias");

        for (ItemSetup item : orcamento.getItens()) {
            System.out.println(item);
        }

        System.out.println("Valor total: R$ " + orcamento.calcularValorTotal());
        System.out.println("Garantia estendida: R$ " + orcamento.calcularTotalGarantia());

        try {
            orcamento.adicionarItem(placa);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            ItemSetup montagemInvalida =
                    new Montagem("Montagem inválida", 80.0, 0);
            orcamento.adicionarItem(montagemInvalida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Itens criados: " + ItemSetup.getTotalItens());

    }
}
