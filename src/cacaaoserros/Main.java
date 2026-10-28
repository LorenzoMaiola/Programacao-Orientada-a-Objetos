package cacaaoserros;

public class Main {
    public static void main(String[] args) {
        testarB1();
        testarB2();
        testarB3();
        testarB4();
        testarB5();
        testarB6();
        testarB7();
        testarB8();
    }

    private static void testarB1() {
        System.out.println("\n--- B1: Limite ---");
        Orcamento o = novoOrcamento();
        for (int i = 1; i <= 5; i++) {
            o.adicionarItem(new Peca("Peça " + i, 100, 1));
        }
        tentar(() -> o.adicionarItem(new Peca("Peça 6", 100, 1)));
        System.out.println("Quantidade final: " + o.getItens().size()
                + " (esperado: 5)");
    }

    private static void testarB2() {
        System.out.println("\n--- B2: Tipo da exceção / repetição ---");
        Orcamento o = novoOrcamento();
        ItemSetup item = new Peca("Teclado", 150, 1);
        o.adicionarItem(item);
        tentar(() -> o.adicionarItem(item));
    }

    private static void testarB3() {
        System.out.println("\n--- B3: Ordem das validações ---");
        Orcamento o = novoOrcamento();
        ItemSetup repetido = new Peca("Peça 1", 100, 1);
        o.adicionarItem(repetido);
        for (int i = 2; i <= 5; i++) {
            o.adicionarItem(new Peca("Peça " + i, 100, 1));
        }
        // A lista está cheia e o item também é repetido.
        // A mensagem esperada é a de item repetido.
        tentar(() -> o.adicionarItem(repetido));
    }

    private static void testarB4() {
        System.out.println("\n--- B4: Remoção ---");
        Orcamento o = novoOrcamento();
        ItemSetup a = new Peca("A", 10, 1);
        ItemSetup b = new Peca("B", 20, 1);
        ItemSetup c = new Peca("C", 30, 1);
        o.adicionarItem(a);
        o.adicionarItem(b);
        o.adicionarItem(c);
        o.removerItem(b);
        System.out.println("Itens após remover B: " + o.getItens()
                + " (esperado: A e C)");
        tentar(() -> o.removerItem(b));

        Orcamento vazio = novoOrcamento();
        tentar(() -> vazio.removerItem(a));
    }

    private static void testarB5() {
        System.out.println("\n--- B5: Contador ---");
        ItemSetup primeiro = new Peca("Válida 1", 100, 1);
        System.out.println("Primeiro código válido: " + primeiro.getCodigo());

        try {
            new Peca("Inválida", -10, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Item inválido: " + e.getMessage());
        }

        ItemSetup segundo = new Peca("Válida 2", 200, 1);
        System.out.println("Segundo código válido: " + segundo.getCodigo());
        System.out.println("Os códigos devem ser consecutivos.");
        System.out.println("Observação: o contador é estático; objetos criados nos testes anteriores"
                + " também o incrementam.");
    }

    private static void testarB6() {
        System.out.println("\n--- B6: Garantia estendida ---");
        Monitor m = new Monitor("Monitor", 1200, 3);
        System.out.printf("Preço calculado: R$ %.2f%n", m.calcularPreco());
        System.out.printf("Garantia de 15%%: R$ %.2f%n",
                m.calcularGarantiaEstendida());
        System.out.println("Esperado: preço R$ 3600,00; garantia R$ 540,00.");
    }

    private static void testarB7() {
        System.out.println("\n--- B7: toString ---");
        ItemSetup item = new Peca("Placa-mãe", 500, 1);
        System.out.println(item);
        System.out.println("Com toString() correto, aparece código, descrição e preço.");
        // Se o método for escrito como tostring(), não sobrescreve Object.toString().
        // Adicionar @Override sobre tostring() gera erro de compilação.
    }

    private static void testarB8() {
        System.out.println("\n--- B8: main ---");
        Orcamento o = new Orcamento(new Solicitante("Carlos"));
        ItemSetup placa = new Peca("Placa de vídeo", 2500, 1);
        o.adicionarItem(placa);

        System.out.println("Solicitante: " + o.getSolicitante().getNome());
        for (ItemSetup item : o.getItens()) {
            System.out.println(item);
        }
        tentar(() -> o.adicionarItem(placa));
    }

    private static Orcamento novoOrcamento() {
        return new Orcamento(new Solicitante("Teste"));
    }

    private static void tentar(Runnable acao) {
        try {
            acao.run();
            System.out.println("Nenhuma exceção foi lançada.");
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
