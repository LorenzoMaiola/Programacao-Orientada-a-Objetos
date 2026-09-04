import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class UsuarioTest {

    private void resetContador(Class<?> tipo) throws Exception {
        Field field = tipo.getDeclaredField("contador");
        field.setAccessible(true);
        field.setInt(null, 0);
    }

    @DisplayName("Ids de Usuario sao sequenciais")
    @Test
    void idsConsecutivosAoCriarInstanciaDeUsuario() throws Exception {
        resetContador(Usuario.class);

        Usuario usuario1 = new Usuario("Nome", "Email@gmail.com");
        Usuario usuario2 = new Usuario("Nome", "Email@gmail.com");
        Usuario usuario3 = new Usuario("Nome", "Email@gmail.com");

        assertEquals(usuario1.getId(), 1);
        assertEquals(usuario2.getId(), 2);
        assertEquals(usuario3.getId(), 3);
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
