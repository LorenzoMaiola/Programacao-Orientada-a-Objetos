package setup.testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import setup.setup.*;

class OrcamentoTest {

    private Cliente cliente;
    private Orcamento orcamento;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Marina Souza", "123.456.789-00");
        orcamento = new Orcamento(cliente, "Blumenau", 7);
    }

    @Test
    void construtorGuardaSolicitanteEComposicaoEntrega() {
        assertSame(cliente, orcamento.getSolicitante());
        assertEquals("Blumenau", orcamento.getCidadeEntrega());
        assertEquals(7, orcamento.getPrazoEntrega());
    }

    @Test
    void solicitanteNullDeveLancarExcecao() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> new Orcamento(null, "Blumenau", 7)
        );
        assertEquals("Solicitante obrigatório", erro.getMessage());

        IllegalArgumentException erroSetter = assertThrows(
                IllegalArgumentException.class,
                () -> orcamento.setSolicitante(null)
        );
        assertEquals("Solicitante obrigatório", erroSetter.getMessage());
    }

    @Test
    void precoBaseInvalidoNaoDeveIncrementarContador() {
        int antes = ItemSetup.getTotalItens();

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> new Peca("Peça inválida", 0.0, 1)
        );

        assertEquals("Preço base inválido", erro.getMessage());
        assertEquals(antes, ItemSetup.getTotalItens());
    }

    @Test
    void codigosSaoGeradosAutomaticamente() {
        int antes = ItemSetup.getTotalItens();
        ItemSetup primeiro = new Peca("A", 100.0, 1);
        ItemSetup segundo = new Montagem("B", 80.0, 2);

        assertEquals(antes + 1, primeiro.getCodigo());
        assertEquals(antes + 2, segundo.getCodigo());
        assertEquals(antes + 2, ItemSetup.getTotalItens());
    }

    @Test
    void montagemCalculaPrecoERejeitaHorasInvalidas() {
        Montagem montagem = new Montagem("Montagem", 80.0, 2);
        assertEquals(160.0, montagem.calcularPreco(), 0.0001);

        int antes = ItemSetup.getTotalItens();
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> new Montagem("Inválida", 80.0, 0)
        );
        assertEquals("Quantidade de horas inválida", erro.getMessage());

        // O super(...) incrementa o contador antes de Montagem validar as horas.
        assertEquals(antes + 1, ItemSetup.getTotalItens());
    }

    @Test
    void pecaCalculaDescontoEGarantia() {
        Peca uma = new Peca("Placa", 2500.0, 1);
        Peca tres = new Peca("Monitor", 1200.0, 3);

        assertEquals(2500.0, uma.calcularPreco(), 0.0001);
        assertEquals(3240.0, tres.calcularPreco(), 0.0001);
        assertEquals(486.0, tres.calcularGarantiaEstendida(), 0.0001);

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> new Peca("Quantidade inválida", 100.0, 0)
        );
        assertEquals("Quantidade inválida", erro.getMessage());
    }

    @Test
    void toStringUsaCodigoDescricaoEPrecoCalculado() {
        ItemSetup item = new Peca("Placa de vídeo", 2500.0, 1);
        assertEquals(item.getCodigo() + " - Placa de vídeo - R$ 2500.0",
                item.toString());
    }

    @Test
    void adicionarItemValidaNullRepeticaoELimiteNaOrdem() {
        IllegalArgumentException nullErro = assertThrows(
                IllegalArgumentException.class,
                () -> orcamento.adicionarItem(null)
        );
        assertEquals("Item inválido", nullErro.getMessage());

        ItemSetup primeiro = new Peca("Peça 1", 100.0, 1);
        orcamento.adicionarItem(primeiro);

        IllegalStateException repetido = assertThrows(
                IllegalStateException.class,
                () -> orcamento.adicionarItem(primeiro)
        );
        assertEquals("Item já incluído no orçamento", repetido.getMessage());

        for (int i = 2; i <= 5; i++) {
            orcamento.adicionarItem(new Peca("Peça " + i, 100.0, 1));
        }

        // Cheio e repetido ao mesmo tempo: a mensagem de repetição vem primeiro.
        IllegalStateException repetidoECheio = assertThrows(
                IllegalStateException.class,
                () -> orcamento.adicionarItem(primeiro)
        );
        assertEquals("Item já incluído no orçamento", repetidoECheio.getMessage());

        IllegalStateException lotado = assertThrows(
                IllegalStateException.class,
                () -> orcamento.adicionarItem(new Peca("Peça 6", 100.0, 1))
        );
        assertEquals("Orçamento lotado", lotado.getMessage());
        assertEquals(5, orcamento.getItens().size());
    }

    @Test
    void removerItemExistenteEInexistente() {
        ItemSetup a = new Peca("A", 10.0, 1);
        ItemSetup b = new Peca("B", 20.0, 1);
        ItemSetup c = new Peca("C", 30.0, 1);
        orcamento.adicionarItem(a);
        orcamento.adicionarItem(b);
        orcamento.adicionarItem(c);

        orcamento.removerItem(b);
        assertEquals(2, orcamento.getItens().size());
        assertTrue(orcamento.getItens().contains(a));
        assertFalse(orcamento.getItens().contains(b));
        assertTrue(orcamento.getItens().contains(c));

        IllegalStateException ausente = assertThrows(
                IllegalStateException.class,
                () -> orcamento.removerItem(b)
        );
        assertEquals("Item não encontrado no orçamento", ausente.getMessage());

        Orcamento vazio = new Orcamento(cliente, "Blumenau", 7);
        IllegalStateException vazioErro = assertThrows(
                IllegalStateException.class,
                () -> vazio.removerItem(a)
        );
        assertEquals("Item não encontrado no orçamento", vazioErro.getMessage());
    }

    @Test
    void calculaTotalEGarantiaPolimorficamenteIncluindoSoftware() {
        orcamento.adicionarItem(new Peca("Placa de vídeo", 2500.0, 1));
        orcamento.adicionarItem(new Peca("Monitor 27 polegadas", 1200.0, 3));
        orcamento.adicionarItem(new Montagem("Montagem e cabeamento", 80.0, 2));

        assertEquals(5900.0, orcamento.calcularValorTotal(), 0.0001);
        assertEquals(861.0, orcamento.calcularTotalGarantia(), 0.0001);

        orcamento.adicionarItem(new Software("Sistema operacional", 300.0, 2));
        assertEquals(6500.0, orcamento.calcularValorTotal(), 0.0001);
        assertEquals(951.0, orcamento.calcularTotalGarantia(), 0.0001);
    }

    @Test
    void limitePermiteCincoItens() {
        for (int i = 1; i <= 5; i++) {
            orcamento.adicionarItem(new Montagem("Serviço " + i, 10.0, 1));
        }
        assertEquals(5, orcamento.getItens().size());
    }
}
