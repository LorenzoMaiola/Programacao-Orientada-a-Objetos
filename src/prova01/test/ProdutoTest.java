package prova01.test;

import org.junit.jupiter.api.Test;

import prova01.src.Produto;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste da avaliação prática de POO - Turma 004.
 */
class ProdutoTest {

    // ===== EXEMPLO FORNECIDO PELO PROFESSOR =====
    @Test
    void deveAdicionarQuantidadeValida() {
        Produto p = new Produto(1, "Caneta");
        p.adicionar(50);
        assertEquals(50, p.getQuantidade());
    }

    // ===== IMPLEMENTE SEUS TESTES A PARTIR DAQUI (Questão 5) =====

    // PL 01 método adicionar
    @Test
    void semQuantidadeDeveLancarExcecao() {
        Produto produtoPl01 = new Produto(123, "Caneta");
        produtoPl01.adicionar(1);

        assertThrows(IllegalArgumentException.class, () -> produtoPl01.adicionar(0));
    }

    @Test
    void quantidadeNegativaDeveLancarExcecao() {
        Produto produtoPl01 = new Produto(123, "Caneta");
        produtoPl01.adicionar(1);

        assertThrows(IllegalArgumentException.class, () -> produtoPl01.adicionar(-1));
    }

    @Test
    void quantidadePositivaDeveAdicionar() {
        Produto produtoPl01 = new Produto(123, "Caneta");
        produtoPl01.adicionar(1);

        produtoPl01.adicionar(1);
        assertEquals(produtoPl01.getQuantidade(), 2);
    }

    // PL 02 método remover
    @Test
    void comEstoqueQuantidadePositivaDeveRemover() {
        Produto produtoPl02 = new Produto(123, "Caneta");
        produtoPl02.adicionar(10);
        
        produtoPl02.remover(2);
        assertEquals(8, produtoPl02.getQuantidade());
    }

    @Test
    void removerComQuantidadeNegativaDeveLancarExcecao() {
        Produto produtoPl02 = new Produto(123, "Caneta");
        produtoPl02.adicionar(10);
        
        assertThrows(IllegalArgumentException.class, () -> produtoPl02.remover(-1));
    }

    @Test
    void removerQuantidadeMaiorQueDisponivelDeveLancarExcecao() {
        Produto produtoPl02 = new Produto(123, "Caneta");
        produtoPl02.adicionar(10);
        
        assertThrows(IllegalStateException.class, () -> produtoPl02.remover(11));
    }
}
