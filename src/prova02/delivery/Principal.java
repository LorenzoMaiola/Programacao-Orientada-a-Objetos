package delivery;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Lorenzo", "123456123");
        Pedido pedido = new Pedido(cliente, "XV de Novembro", 1200);
        
        Prato risoto = new Prato("Risoto de cogumelos", 45, 2);
        Bebida suco = new Bebida("Suco de uva", 10.00, 6);
        Bebida agua = new Bebida("Água com gás", 5.00, 2);

        
        // ItemCardapio[] itens = {risoto,suco,agua};
        pedido.adicionarItens(risoto);
        pedido.adicionarItens(suco);
        pedido.adicionarItens(agua);
    
        System.out.println("Pedido para a rua "+ pedido.getRuaEntrega() + " N° "+pedido.getNumeroEntrega()+ " \nComprado por "+ pedido.getComprador().getNome()+":");
        for (ItemCardapio itemCardapio : pedido.getItens()) {
            System.out.println(itemCardapio.toString());
        }
        
        System.out.println("Valor total do pedido: "+pedido.calcularValorTotal() + "\nImpostos: "+pedido.calcularTotalImpostos());
        
        try{
            pedido.adicionarItens(risoto);
        }
        catch(IllegalStateException e ){
            System.out.println("\nProvando que não é possível adicionar o mesmo item novamente. " +e.getMessage());
        }
    }
    /*private static void executarDemonstracao(Plataforma plataforma) {
        System.out.println("\n=== Demonstração: contador de reproduções ===");
        Usuario apresentador = new Usuario("Ana Souza", "ana@sonora.com");
        plataforma.cadastrarUsuario(apresentador);

        Musica m1 = new Musica("Bohemian Rhapsody", 354, "A Night at the Opera", "Queen");
        Musica m2 = new Musica("Imagine", 183, "Imagine", "John Lennon");
        Podcast p1 = new Podcast("Papo de Código", 2400, apresentador, 12);
        Podcast p2 = new Podcast("Ciência em Foco", 1800, apresentador, 3);
        plataforma.cadastrarMusica(m1);
        plataforma.cadastrarMusica(m2);
        plataforma.cadastrarPodcast(p1);
        plataforma.cadastrarPodcast(p2);

        for (int i = 0; i < 3; i++)
            m1.reproduzir();
        m2.reproduzir();
        for (int i = 0; i < 2; i++)
            p1.reproduzir();
        p2.reproduzir();

        System.out.println("\nContadores de reproduções:");
        Conteudo[] conteudos = { m1, m2, p1, p2 };
        for (Conteudo c : conteudos) {
            System.out.println("  " + c.getTitulo() + " -> " + c.getReproducoes());
        }

        System.out.println("Demonstração: planos de " + apresentador.getNome() + " ===");
        System.out.println("Ao ser criado: " + apresentador.getPlano().resumo());
        apresentador.assinar(new PlanoIndividual(21.90));
        System.out.println("Individual:    " + apresentador.getPlano().resumo());
        apresentador.assinar(new PlanoFamilia(30.0, 3));
        System.out.println("Família:       " + apresentador.getPlano().resumo());
        try {
            apresentador.assinar(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Plano nulo recusado: " + e.getMessage());
        }
        System.out.println("(Usuário demonstração criado com id " + apresentador.getId() + ")");
    } */
}
