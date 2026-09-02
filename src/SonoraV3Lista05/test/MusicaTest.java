import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import SonoraV3Lista05.src.Musica;

public class MusicaTest {

    @Test
    public void testGetDuracaoFormatada(){
        Musica musica = new Musica("Titulo", "Artista", 125);
        assertEquals("02:05", musica.getDuracaoFormatada(musica.getDuracaoSegundos()));
    }

}