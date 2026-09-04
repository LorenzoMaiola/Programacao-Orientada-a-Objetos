import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class MusicaTest {

    private void resetContador(Class<?> tipo) throws Exception {
        Field field = tipo.getDeclaredField("contador");
        field.setAccessible(true);
        field.setInt(null, 0);
    }

    public Musica criarMusica(int duracaoSegundos) {
        return new Musica("Rotten Apple", "Alice in Chains", duracaoSegundos);
    }
    // PL01

    // "125, 02:05",
    @DisplayName("Caso 1: duração com minutos e segundos")
    @Test
    void duracaoMinutoSegundo() {
        assertEquals("02:05", criarMusica(125).getDuracaoFormatada());
    }

    // "90, 01:30"
    @DisplayName("Caso 2: duração redonda em minutos")
    @Test
    void duracaoMinutoRedondo() {
        assertEquals("01:30", criarMusica(90).getDuracaoFormatada());
    }

    // "5, 00:05"
    @DisplayName("Caso 3: menos de um minuto, com zero à esquerda")
    @Test
    void duracaoZeroEsquerda() {
        assertEquals("00:05", criarMusica(5).getDuracaoFormatada());
    }

    // "600, 10:00"
    @DisplayName("Caso 4: dois dígitos nos minutos")
    @Test
    void duracaoDoisDigitosMinutos() {
        assertEquals("10:00", criarMusica(600).getDuracaoFormatada());
    }

    // "599, 09:59"
    @DisplayName("Caso 5: valor logo abaixo de dez minutos")
    @Test
    void duracaoValorAbaixoDeDezMinutos() {
        assertEquals("09:59", criarMusica(599).getDuracaoFormatada());
    }

    // PL02
    @DisplayName("Titulo vazio deve ser rejeitado")
    @Test
    void tituloVazioDeveSerRejeitado() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("", "artista", 120));
    }

    @DisplayName("Titulo nulo deve ser rejeitado")
    @Test
    void tituloNuloDeveSerRejeitado() {
        assertThrows(IllegalArgumentException.class, () -> new Musica(null, "artista", 120));
    }

    @DisplayName("Artista vazio deve ser rejeitado")
    @Test
    void artistaVazioDeveSerRejeitado() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("Titulo", "", 120));
    }

    @DisplayName("Duracao zero deve ser rejeitada")
    @Test
    void duracaoZeroDeveSerRejeitada() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("titulo", "artista", 0));
    }

    @DisplayName("Duracao negativa deve ser rejeitada")
    @Test
    void duracaoNegativaDeveSerRejeitada() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("Titulo", "artista", -2));
    }

    @DisplayName("Dados validos criam a musica")
    @Test
    void dadosValidosDevemCriarMusica() {
        Musica musica = assertDoesNotThrow(() -> new Musica("TItulo", "artista", 120));
        assertNotNull(musica);
        assertTrue(musica.getId() > 0);
    }



    //PL 07

    @DisplayName("Uma unica chamada de reproduzir() incrementa o contador")
    @Test
    void aoChamarMetodoIncrementaContador(){
        Musica musica = new Musica("Titulo", "Artista", 120);
        musica.reproduzir();


        assertEquals(musica.getReproducoes(), 1);
    }

    @DisplayName("Multiplas chamadas sequenciais somam corretamente")
    @Test
    void aoChamarMetodoIncrementaCorretamenteTodasAsVezes(){
        Musica musica = new Musica("Titulo", "Artista", 120);
        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();

        assertEquals(musica.getReproducoes(), 5);
    }

    @DisplayName("Nenhuma chamada mantem o contador zerado")
    @Test
    void naoChamarNaoIncrementaContador(){
        Musica musica = new Musica("Titulo", "Artista", 120);
        assertEquals(musica.getReproducoes(), 0);
    }

    //PL08
    
    @DisplayName("Ids de Musica sao sequenciais")
    @Test
    void idsConsecutivosAoCriarInstanciaDeMusica() throws Exception {
        resetContador(Musica.class);

        Musica musica1 = new Musica("Titulo", "Artista", 230);
        Musica musica2 = new Musica("Titulo", "Artista", 230);
        Musica musica3 = new Musica("Titulo", "Artista", 230);

        assertEquals(musica1.getId(), 1);
        assertEquals(musica2.getId(), 2);
        assertEquals(musica3.getId(), 3);
    }

    @DisplayName("Contadores de id de Musica e Usuario sao independentes")
    @Test
    void IdsDeMusicaEUsuarioDevemSerIndependentes() throws Exception {
        resetContador(Usuario.class);
        resetContador(Musica.class);

        Usuario usuario1 = new Usuario("Nome", "Email@gmail.com");
        Musica musica1 = new Musica("Titulo", "Artista", 230);

        Usuario usuario2 = new Usuario("Nome", "Email@gmail.com");
        Musica musica2 = new Musica("Titulo", "Artista", 230);

        Usuario usuario3 = new Usuario("Nome", "Email@gmail.com");
        Musica musica3 = new Musica("Titulo", "Artista", 230);

        assertEquals(usuario1.getId(), 1);
        assertEquals(musica1.getId(), 1);

        assertEquals(usuario2.getId(), 2);
        assertEquals(musica2.getId(), 2);

        assertEquals(usuario3.getId(), 3);
        assertEquals(musica3.getId(), 3);
    }


}