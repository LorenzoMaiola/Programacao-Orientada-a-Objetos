package aquecimento.a1;

public class Senha {
    //R: totalEmitidas deve ser static. Removendo static, as senhas ficam todas com numero 1. Porque codigo, passa a ser uma variavel de instancia
    //R: o getter de uma variavel static deve ser static tambem, senao, da erro de compilacao.
    //R: contador e incrementado na segunda linha do construtor, apos o setter de setor fazer as validacoes necessarias. Assim, o numero so e consumido por uma senha caso seja realmente valida
    private static int totalEmitidas = 0;
    private int numero;
    private String setor;

    public Senha(String setor) {
        setSetor(setor);
        totalEmitidas++;
        numero = totalEmitidas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        if(setor == null || setor.isBlank())
            throw new IllegalArgumentException("Setor obrigatório");
        this.setor = setor;
    }

    public static int getTotalEmitidas(){
        return totalEmitidas;
    }

    @Override
    public String toString() {
        return "" + numero + " - " + setor;
    }

}
