import org.junit.jupiter.api.*;

import static org.junit.Assert.assertThrows;
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

    //PL03
    
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


    //PL04 - validar getNaPosicao()
    
    @DisplayName("Indice valido no meio da playlist devolve a musica certa")
    @Test
    void indiceValidoDevolveMusicaCerta(){
        Musica musica1 = new Musica("Titulo", "artista", 120);
        Musica musica2 = new Musica("Titulo", "artista", 120);
        Musica musica3 = new Musica("Titulo", "artista", 120);

        Playlist playlist = new Playlist("Playlist", usuario);
        playlist.adicionar(musica1);
        playlist.adicionar(musica2);
        playlist.adicionar(musica3);
        assertEquals(playlist.getNaPosicao(1), musica2);
    }

    @DisplayName("Indice negativo deve ser rejeitado")
    @Test
    void indiceNegativoDeveSerRejeitado(){
        Playlist playlist = criarEPreencherPlaylist(3);
        assertThrows(IndexOutOfBoundsException.class, () -> playlist.getNaPosicao(-1));
    }

    @DisplayName("Indice igual a quantidade")
    @Test
    void indiceIgualAQuantidadeDeveSerRejeitado(){
        Playlist playlist = criarEPreencherPlaylist(3);
        assertThrows(IndexOutOfBoundsException.class, () -> playlist.getNaPosicao(3));
    }

    @DisplayName("Índice maior que a quantidade")
    @Test
    void indiceMaiorQueAQuantidadeDeveSerRejeitada(){
        Playlist playlist = criarEPreencherPlaylist(3);
        assertThrows(IndexOutOfBoundsException.class, () -> playlist.getNaPosicao(10));
    }

    @DisplayName("Playlist vazia, qualquer indice é inválido")
    @Test
    void playlistVaziaNaoDeveAceitarNenhumIndice(){
        Playlist playlist = new Playlist("nome", usuario);
        assertThrows(IndexOutOfBoundsException.class, () -> playlist.getNaPosicao(0));
    }

    //PL05 - validar Playlist.removerNaPosicao()
}
