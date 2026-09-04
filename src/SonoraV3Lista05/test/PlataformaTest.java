import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

public class PlataformaTest {

    private void resetContador(Class<?> tipo) throws Exception {
        Field field = tipo.getDeclaredField("contador");
        field.setAccessible(true);
        field.setInt(null, 0);
    }

    private Musica criarMusica() {
        Musica ms = new Musica("Bohemian Rhapsody", "Queen", 120);
        return ms;
    }

    private Musica criarMusica(String titulo) {
        Musica ms = new Musica(titulo, "Queen", 120);
        return ms;
    }

    // PL06

    @DisplayName("Buscar por titulo exatamente igual ao cadastrado")
    @Test
    void buscarTituloIgualDeveSerAchado() {
        Plataforma plataforma = new Plataforma();
        Musica musica = criarMusica();
        Musica musica2 = criarMusica("Another One Bites The Dust");
        Musica musica3 = criarMusica("bohemian rhapsody");

        plataforma.cadastrarMusica(musica);
        plataforma.cadastrarMusica(musica2);// para provar que pegou certo
        plataforma.cadastrarMusica(musica3);// para provar que pegou certo

        assertEquals(musica, plataforma.buscarMusica("Bohemian Rhapsody"));
    }

    @DisplayName("Buscar por titulo com diferenca de maiusculas e minusculas")
    @Test
    void tituloComCapitalizacaoDiferenteDeveSerEncontrado() {
        Plataforma plataforma = new Plataforma();
        Musica musica = criarMusica();
        plataforma.cadastrarMusica(musica);
        
        
        assertEquals(musica, plataforma.buscarMusica("bohemian rhapsody"));
    }

    @DisplayName("Buscar por titulo inexistente")
    @Test
    void buscarPorTituloQueNaoExisteDeveLancarExcecao(){
        Plataforma plataforma = new Plataforma();
        Musica musica1 = criarMusica();
        Musica musica2 = criarMusica("Another One Bites The Dust");
        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);

        assertNull(plataforma.buscarMusica("Título Inexistente"));

    }

    @DisplayName("Buscar por id existente")
    @Test
    void buscarPorIdExistenteRetornaMusica() throws Exception {
        resetContador(Musica.class);

        Plataforma plataforma = new Plataforma();
        Musica musica1 = criarMusica();
        Musica musica2 = criarMusica("Outra Música");

        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);

        assertEquals(musica1, plataforma.buscarMusicaPorId(musica1.getId()));
    }

    @DisplayName("Buscar por id inexistente")
    @Test
    void buscarPorIdInexistenteRetornaNull() throws Exception {
        resetContador(Musica.class);

        Plataforma plataforma = new Plataforma();
        Musica musica1 = criarMusica();
        Musica musica2 = criarMusica("Outra Música");

        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);

        assertNull(plataforma.buscarMusicaPorId(musica1.getId() + 1000));
    }
}
