package SonoraV2Lista04;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();

        boolean continuar = true;

        while (continuar) {
            int opcao = 0;
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Opção inserida é inválida! Por favor insira um número");
            }
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
                case 0:
                    continuar = false;
                    System.out.println("Encerrando o Sonora...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
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
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarMusica(Scanner scanner, Plataforma plataforma) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Duração (segundos): ");
        int duracao = scanner.hasNextInt() ? scanner.nextInt() : 0;
        scanner.nextLine();

        Musica musica = new Musica(titulo, artista, duracao);
        boolean ok = plataforma.cadastrarMusica(musica);
        System.out.println(ok
                ? "Música cadastrada com id " + musica.getId()
                : "Não foi possível cadastrar a música.");
    }

    private static void cadastrarUsuario(Scanner scanner, Plataforma plataforma) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        boolean usuarioCadastrado = plataforma.cadastrarUsuario(usuario);
        System.out.println(usuarioCadastrado
                ? "Usuário cadastrado com id " + usuario.getId()
                : "Não foi possível cadastrar o usuário.");
    }

    private static void criarPlaylistEAdicionar(Scanner scanner, Plataforma plataforma) {
        System.out.print("Nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        System.out.print("Nome do usuário dono: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Email do usuário dono: ");
        String emailUsuario = scanner.nextLine();

        Usuario dono = new Usuario(nomeUsuario, emailUsuario);
        plataforma.cadastrarUsuario(dono);

        Playlist playlist = new Playlist(nomePlaylist, dono);

        boolean adicionarMais = true;
        while (adicionarMais) {
            System.out.print("Id da música para adicionar (0 para parar): ");
            int idMusica = scanner.hasNextInt() ? scanner.nextInt() : 0;
            scanner.nextLine();

            if (idMusica == 0) {
                adicionarMais = false;
            } else {
                Musica musica = plataforma.buscarMusicaPorId(idMusica);
                boolean musicaAdicionada = playlist.adicionar(musica);
                System.out.println(musicaAdicionada ? "Adicionada!" : "Não foi possível adicionar.");
            }
        }

        System.out.println("Playlist '" + playlist.getNome() + "' criada com " + playlist.getQuantidade()
                + " música(s), duração total: " + playlist.getDuracaoTotalSegundos() + "s");
    }

    private static void buscarMusicaPorId(Scanner scanner, Plataforma plataforma) {
        System.out.print("Id da música: ");
        int id = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

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
        System.out.print("Id da música a reproduzir: ");
        int id = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

        Musica musica = plataforma.buscarMusicaPorId(id);
        if (musica != null) {
            musica.reproduzir();
            System.out.println("Reproduzida! Total de reproduções: " + musica.getReproducoes());
        } else {
            System.out.println("Música não encontrada.");
        }
    }

    private static void listarAcervo(Plataforma plataforma) {
        System.out.println("Acervo (" + plataforma.getTotalMusicas() + " música(s))");
        for (int id = 1; id <= plataforma.getTotalMusicas(); id++) {
            Musica musica = plataforma.buscarMusicaPorId(id);
            if (musica != null) {
                System.out.println(formatarMusica(musica));
            }
        }
    }

    private static String formatarMusica(Musica m) {
        return "[" + m.getId() + "] " + m.getTitulo() + " - " + m.getArtista()
                + " (" + m.getDuracaoFormatada() + ") | reproduções: " + m.getReproducoes();
    }

}
