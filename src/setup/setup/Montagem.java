package setup.setup;

public class Montagem extends ItemSetup {
    private int horas;

    public Montagem(String descricao, double precoBase, int horas) {
        super(descricao, precoBase);

        // Esta validação ocorre depois do construtor da superclasse.
        // Se horas for inválido, ItemSetup já terá incrementado totalItens.
        if (horas <= 0) {
            throw new IllegalArgumentException("Quantidade de horas inválida");
        }
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * horas;
    }
}
