import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        boolean continuar = true;

        // Conteudo c = new Conteudo("Generico", 120); ->"Cannot instantiate the type Conteudo" (concretas) podem.
        // Plano p = new Plano("Generico", 1); -> "Cannot instantiate the type Plano"
        // PlanoPago pp = new PlanoPago("Generico", 1, 10.0); -> mesmo erro: PlanoPago também é abstrata.
        // class PlanoGratuitoPremium extends PlanoGratuito { } ->"The type PlanoGratuitoPremium cannot subclass the final class PlanoGratuito" (javac: "cannot inherit from final PlanoGratuito"). Uma classe final
        try {
            while (continuar) {
                int opcao;
                exibirMenu();
                try {
                    opcao = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inserida é inválida! Por favor insira um número");
                    continue;
                }

                try {
                    switch (opcao) {
                        case 1:
                            cadastrarMusica(scanner, plataforma);
                            break;
                        case 2:
                            cadastrarUsuario(scanner, plataforma);
                            break;
                        case 3:
                            criarPlaylistEAdicionar(scanner, plataforma);
                            break;
                        case 4:
                            buscarMusicaPorId(scanner, plataforma);
                            break;
                        case 5:
                            buscarMusicaPorTitulo(scanner, plataforma);
                            break;
                        case 6:
                            reproduzirMusica(scanner, plataforma);
                            break;
                        case 7:
                            listarAcervo(plataforma);
                            break;
                        case 8:
                            seguirUsuario(scanner, plataforma);
                            break;
                        case 9:
                            deixarDeseguirUsuario(scanner, plataforma);
                            break;
                        case 10:
                            cadastrarPodcast(scanner, plataforma);
                            break;
                        case 11:
                            reproduzirPodcast(scanner, plataforma);
                            break;
                        case 12:
                            trocarPlano(scanner, plataforma);
                            break;
                        case 13:
                            exibirResumoDoPlano(scanner, plataforma);
                            break;
                        case 14:
                            executarDemonstracao(plataforma);
                            break;
                        case 0:
                            continuar = false;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } catch (Exception e) {
                    System.out.println("Algo deu errado! " + e.getMessage());
                }
            }
        } finally {
            System.out.println("Fechando o sonora!");
            scanner.close();
        }
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Cadastrar música manualmente");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Criar playlist e adicionar músicas");
        System.out.println("4 - Buscar música por id");
        System.out.println("5 - Buscar música por título");
        System.out.println("6 - Reproduzir uma música");
        System.out.println("7 - Listar acervo");
        System.out.println("8 - Seguir um usuário");
        System.out.println("9 - Deixar de seguir um usuário");
        System.out.println("10 - Cadastrar um podcast");
        System.out.println("11 - Reproduzir um podcast");
        System.out.println("12 - Trocar o plano de um usuário");
        System.out.println("13 - Exibir o resumo do plano de um usuário");
        System.out.println("14 - Executar demonstração (reproduções e planos)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    private static double lerDecimal(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número (ex.: 21.90).");
            }
        }
    }

    private static void cadastrarMusica(Scanner scanner, Plataforma plataforma) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Álbum: ");
        String album = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        int duracao = lerInteiro(scanner, "Duração (segundos): ");

        try {
            Musica musica = new Musica(titulo, duracao, album, artista);
            plataforma.cadastrarMusica(musica);
            System.out.println("Música cadastrada com id " + musica.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar a música! " + e.getMessage());
        }
    }

    private static void cadastrarUsuario(Scanner scanner, Plataforma plataforma) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Usuario usuario = new Usuario(nome, email);
            plataforma.cadastrarUsuario(usuario);
            System.out.println("Usuário cadastrado com id " + usuario.getId()
                    + " (plano: " + usuario.getPlano().getNome() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o usuário! " + e.getMessage());
        }
    }

    private static void criarPlaylistEAdicionar(Scanner scanner, Plataforma plataforma) {
        System.out.print("Nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        System.out.print("Nome do usuário dono: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Email do usuário dono: ");
        String emailUsuario = scanner.nextLine();

        try {
            Usuario dono = new Usuario(nomeUsuario, emailUsuario);
            plataforma.cadastrarUsuario(dono);

            Playlist playlist = new Playlist(nomePlaylist, dono);

            boolean adicionarMais = true;
            while (adicionarMais) {
                int idMusica = lerInteiro(scanner, "Id da música para adicionar (0 para parar): ");

                if (idMusica == 0) {
                    adicionarMais = false;
                } else {
                    Musica musica = plataforma.buscarMusicaPorId(idMusica);
                    if (musica == null) {
                        System.out.println("Música não encontrada.");
                    } else {
                        boolean musicaAdicionada = playlist.adicionar(musica);
                        System.out.println(musicaAdicionada ? "Adicionada!" : "Não foi possível adicionar.");
                    }
                }
            }

            System.out.println("Playlist '" + playlist.getNome() + "' criada com " + playlist.getQuantidade()
                    + " música(s), duração total: " + playlist.getDuracaoTotalSegundos() + "s");

            int indice = lerInteiro(scanner,
                    "Deseja consultar uma posição da playlist? Digite o índice (-1 para pular): ");

            if (indice != -1) {
                try {
                    Musica musicaNaPosicao = playlist.getNaPosicao(indice);
                    System.out.println("Música na posição " + indice + ": " + formatarMusica(musicaNaPosicao));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Posição inválida! " + e.getMessage());
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível criar a playlist! " + e.getMessage());
        }
    }

    private static void buscarMusicaPorId(Scanner scanner, Plataforma plataforma) {
        int id = lerInteiro(scanner, "Id da música: ");

        Musica musica = plataforma.buscarMusicaPorId(id);
        System.out.println(musica != null ? formatarMusica(musica) : "Música não encontrada.");
    }

    private static void buscarMusicaPorTitulo(Scanner scanner, Plataforma plataforma) {
        System.out.print("Título da música: ");
        String titulo = scanner.nextLine();

        Musica musica = plataforma.buscarMusica(titulo);
        System.out.println(musica != null ? formatarMusica(musica) : "Música não encontrada.");
    }

    private static void reproduzirMusica(Scanner scanner, Plataforma plataforma) {
        int id = lerInteiro(scanner, "Id da música a reproduzir: ");

        Musica musica = plataforma.buscarMusicaPorId(id);
        if (musica != null) {
            musica.reproduzir();
            System.out.println("Reproduzida! Total de reproduções desta música: " + musica.getReproducoes());
        } else {
            System.out.println("Música não encontrada.");
        }
    }

    private static void listarAcervo(Plataforma plataforma) {
        System.out.println("Acervo (" + plataforma.getTotalMusicas() + " música(s))");
        for (Musica musica : plataforma.getMusicas()) {
            System.out.println(formatarMusica(musica));
        }
    }

    private static String formatarMusica(Musica m) {
        return "[" + m.getId() + "] " + m.getTitulo() + " - " + m.getArtista()
                + " (" + m.getDuracaoFormatada() + ") | reproduções: " + m.getReproducoes();
    }

    private static void seguirUsuario(Scanner scanner, Plataforma plataforma) {
        try {
            int idSeguidor = lerInteiro(scanner, "Insira o id do usuário que será um seguidor: ");
            Usuario seguidor = plataforma.getUsuarioPorId(idSeguidor);

            int idSeguido = lerInteiro(scanner, "Insira o id do usuário a ser seguido: ");
            Usuario seguido = plataforma.getUsuarioPorId(idSeguido);

            seguidor.seguir(seguido);
            System.out.println(seguidor.getNome() + " agora segue " + seguido.getNome() + "!");

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Não foi possível seguir! " + e.getMessage());
        }
    }

    private static void deixarDeseguirUsuario(Scanner scanner, Plataforma plataforma) {
        try {
            int idSeguidor = lerInteiro(scanner, "Insira o id do usuário que quer parar de seguir outro usuário: ");
            Usuario seguidor = plataforma.getUsuarioPorId(idSeguidor);

            int idSeguido = lerInteiro(scanner, "Insira o id do usuário a parar de ser seguido: ");
            Usuario seguido = plataforma.getUsuarioPorId(idSeguido);

            seguidor.deixarDeSeguir(seguido);
            System.out.println(seguidor.getNome() + " deixou de seguir " + seguido.getNome() + ".");

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Não foi possível parar de seguir! " + e.getMessage());
        }
    }

    private static void cadastrarPodcast(Scanner scanner, Plataforma plataforma) {
        try {
            System.out.print("Insira o título do podcast: ");
            String titulo = scanner.nextLine();
            int duracaoSegundos = lerInteiro(scanner, "Insira a duração do podcast (segundos): ");
            int idApresentador = lerInteiro(scanner, "Insira id do apresentador do podcast: ");
            Usuario apresentador = plataforma.getUsuarioPorId(idApresentador);
            int numeroEpisodio = lerInteiro(scanner, "Insira o número do episódio: ");

            Podcast podcast = new Podcast(titulo, duracaoSegundos, apresentador, numeroEpisodio);
            plataforma.cadastrarPodcast(podcast);
            System.out.println("Podcast cadastrado com sucesso!");
            System.out.println(podcast);
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o podcast! " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Não foi possível encontrar o apresentador! " + e.getMessage());
        }
    }

    private static void reproduzirPodcast(Scanner scanner, Plataforma plataforma) {
        try {
            int idPodcast = lerInteiro(scanner, "Insira o id do podcast a reproduzir: ");
            Podcast podcast = plataforma.getPodcastPorId(idPodcast);
            podcast.reproduzir();
            System.out.println("Reproduzido! Total de reproduções deste podcast: " + podcast.getReproducoes());
        } catch (IllegalStateException e) {
            System.out.println("Podcast não encontrado! " + e.getMessage());
        }
    }

    private static void trocarPlano(Scanner scanner, Plataforma plataforma) {
        try {
            int idUsuario = lerInteiro(scanner, "Id do usuário que vai trocar de plano: ");
            Usuario usuario = plataforma.getUsuarioPorId(idUsuario);
            System.out.println("Plano atual: " + usuario.getPlano().resumo());

            System.out.println("Novo plano:");
            System.out.println("1 - Gratuito (com anúncios)");
            System.out.println("2 - Individual");
            System.out.println("3 - Família");
            int escolha = lerInteiro(scanner, "Escolha o plano: ");

            Plano novoPlano;
            switch (escolha) {
                case 1:
                    novoPlano = new PlanoGratuito();
                    break;
                case 2:
                    novoPlano = new PlanoIndividual(lerDecimal(scanner, "Preço mensal (R$): "));
                    break;
                case 3:
                    double preco = lerDecimal(scanner, "Preço mensal base (R$): ");
                    int membros = lerInteiro(scanner, "Quantidade de membros (1 a 6): ");
                    novoPlano = new PlanoFamilia(preco, membros);
                    break;
                default:
                    System.out.println("Plano inválido. Nada foi alterado.");
                    return;
            }

            usuario.assinar(novoPlano);
            System.out.println("Plano alterado! " + usuario.getPlano().resumo());
        } catch (IllegalStateException e) {
            System.out.println("Não foi possível trocar o plano! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível trocar o plano! " + e.getMessage());
        }
    }

    private static void exibirResumoDoPlano(Scanner scanner, Plataforma plataforma) {
        try {
            int idUsuario = lerInteiro(scanner, "Id do usuário: ");
            Usuario usuario = plataforma.getUsuarioPorId(idUsuario);
            Plano plano = usuario.getPlano();
            System.out.println(usuario.getNome() + " -> " + plano.resumo()
                    + " | anúncios: " + (plano.temAnuncios() ? "sim" : "não"));
        } catch (IllegalStateException e) {
            System.out.println("Usuário não encontrado! " + e.getMessage());
        }
    }

    // demo

    private static void executarDemonstracao(Plataforma plataforma) {
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
    }
}