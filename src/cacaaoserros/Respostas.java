package cacaaoserros;

public class Respostas {
/*
B1 — Limite
- Erro: `size() > 5` só bloqueia quando já existem mais de cinco itens.
- Teste: adicionar um sexto item com cinco já cadastrados.
- Obtido: o sexto é adicionado; esperado: `IllegalStateException`.
- Correção: `if (itens.size() >= 5)`.

B2 — Tipo da exceção
- Erro: item repetido não é argumento inválido; é uma operação impedida pelo estado do orçamento.
- Teste: adicionar duas vezes a mesma instância.
- Obtido: `IllegalArgumentException`; esperado: `IllegalStateException`.
- Correção: usar `IllegalStateException` para item repetido. Para `null`, usar `IllegalArgumentException`.

B3 — Ordem das validações
- Erro: a lista cheia é verificada antes da repetição.
- Teste: orçamento cheio e tentativa de adicionar um item que já está nele.
- Obtido: mensagem “Orçamento lotado”; esperado: “Item já incluído no orçamento”.
- Correção: validar `null`, repetição e limite, nessa ordem.

B4 — Remoção
- Erro: o código lança exceção ao encontrar um item diferente do que quer remover.
- Teste: lista `[A, B, C]`, removendo `B`; também testar lista vazia.
- Obtido: falha antes de remover `B`; lista vazia não lança exceção.
- Esperado: remover `B`; se o item não existir, lançar exceção.
- Correção: `if (!itens.remove(item)) { throw new IllegalStateException(...); }`.

B5 — Contador
- Erro: incrementar `totalItens` antes de validar o preço.
- Teste: criar item válido, tentar um inválido e criar outro válido.
- Obtido: códigos com um salto (por exemplo, 1 e 3).
- Esperado: códigos consecutivos (1 e 2).
- Correção: validar todos os argumentos antes de incrementar o contador.

B6 — Base do cálculo
- Erro pretendido: usar `getPrecoBase()` em vez do preço calculado.
- Teste: três monitores de R$ 1.200,00.
- Obtido pelo trecho dado: `1200 * 3 * 0,15 = R$ 540,00`.
- Esperado: `calcularPreco() * 0.15 = 3600 * 0,15 = R$ 540,00`.
- Observação: nesse caso, os valores coincidem; o trecho dado já multiplica pela quantidade. A correção pedida é `return calcularPreco() * 0.15;`.

B7 — `toString`
- Erro: `tostring()` não sobrescreve `Object.toString()` porque Java diferencia maiúsculas e minúsculas.
- Teste: `System.out.println(item)`.
- Obtido: representação padrão, como `Peca@...`.
- Esperado: texto formatado com código, descrição e preço.
- Correção: `@Override public String toString()`. Com `@Override` sobre `tostring()`, ocorre erro de compilação porque não há método sobrescrito com essa assinatura.

B8 — `main`
1. Tipo da variável: prefira `ItemSetup placa` para programar usando a abstração.
2. Solicitante: concatenar o objeto pode imprimir `Solicitante@...`; use `getNome()`.
3. Itens: percorra a lista e imprima cada item para usar o `toString()` formatado.
4. Última linha: adicionar a mesma instância de novo deve lançar `IllegalStateException`.
 */
}
