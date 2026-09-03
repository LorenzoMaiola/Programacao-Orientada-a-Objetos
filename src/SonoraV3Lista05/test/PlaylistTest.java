import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    Usuario usuario = new Usuario("Lorenzo", "lorenzo@gmail.com");

    // metodo pra deixar playlist cheia
    Playlist criarEPreencherPlaylist(int quantidade) {
        Playlist playlist = new Playlist("Nome", usuario);
        for (int i = 1; i <= quantidade; i++) {
            playlist.adicionar(criarMusica());
        }
        return playlist;
    }

    // metodo de criar musicas para metodo da plaulist
    Musica criarMusica() {
        return new Musica("Titulo", "Artista", 120);
    }

    @DisplayName("Adicionar musica em playlist com espaco disponivel")
    @Test
    void playlistComEspacoDeveAdicionarMusica() {
        Playlist playlist = new Playlist("Playlist", usuario);
        assertTrue(playlist.adicionar(criarMusica()));
        assertTrue(playlist.getQuantidade() == 1);
    }

    @DisplayName("Adicionar ate atingir exatamente a capacidade maxima")
    @Test
    void playlistDeveAdicionarMusicaAteQuantidadeMaxima() {
        Playlist playlist = criarEPreencherPlaylist(99);
        assertTrue(playlist.adicionar(criarMusica()));
        assertTrue(playlist.getQuantidade() == 100);

    }

    @DisplayName("Adicionar quando a playlist ja esta cheia")
    @Test
    void playlistCheiaNaoDeveAdicionarMusica() {
        Playlist playlist = criarEPreencherPlaylist(100);
        assertFalse(playlist.adicionar(criarMusica()));
        assertTrue(playlist.getQuantidade() == 100);
    }

    @DisplayName("Adicionar musica nula em playlist com espaco")
    @Test
    void playlistNaoDeveAceitarMusicaNula() {
        Playlist playlist = new Playlist("Playlist", usuario);
        assertThrows(IllegalArgumentException.class, () -> playlist.adicionar(null));
    }
}
