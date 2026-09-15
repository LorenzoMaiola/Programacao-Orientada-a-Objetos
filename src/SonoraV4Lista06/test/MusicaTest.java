import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MusicaTest {

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
}