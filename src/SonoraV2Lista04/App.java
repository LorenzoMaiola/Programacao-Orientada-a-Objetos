package SonoraV2Lista04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();

        boolean continuar = true;
        try {
            while (continuar) {
                int opcao = 0;
                exibirMenu();
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inserida é inválida! Por favor insira um número");
                    continue;
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
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } finally {
            System.out.println("Fechando o sonora!");//provando que o finally sempre executa
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

        try {
            Musica musica = new Musica(titulo, artista, duracao);
            plataforma.cadastrarMusica(musica);
            System.out.println("Música cadastrada com id " + musica.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar a música!" + e.getMessage());

        }
    }

    private static void cadastrarUsuario(Scanner scanner, Plataforma plataforma) {
        try{
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        plataforma.cadastrarUsuario(usuario);
        System.out.println("Usuário cadastrado com id " + usuario.getId());
        } catch(IllegalArgumentException e) {
            System.out.println("Não foi possível cadastrar o usuário. "+ e.getMessage());
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

        System.out.print("Deseja consultar uma posição da playlist? Digite o índice (-1 para pular): ");
        int indice = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

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

    private static void reproduzirMusica(Scanner scanner, Plataforma plataforma) {// falta try/catch
        try {
            System.out.print("Id da música a reproduzir: ");
            int id = scanner.nextInt();
            Musica musica = plataforma.buscarMusicaPorId(id);
            musica.reproduzir();
            System.out.println("Reproduzida! Total de reproduções: " + musica.getReproducoes());

        } catch (InputMismatchException e) {
            System.out.println("Você deve inserir um número! " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Música não encontrada! " + e.getMessage());
        }

    }

    private static void listarAcervo(Plataforma plataforma) {
        System.out.println("Acervo (" + plataforma.getTotalMusicas() + " música(s))");
        for (int id = 1; id <= plataforma.getTotalMusicas(); id++) {
            Musica musica = plataforma.buscarMusicaPorId(id);
            System.out.println(formatarMusica(musica));
        }
    }

    private static String formatarMusica(Musica m) {
        return "[" + m.getId() + "] " + m.getTitulo() + " - " + m.getArtista()
                + " (" + m.getDuracaoFormatada() + ") | reproduções: " + m.getReproducoes();
    }

}
