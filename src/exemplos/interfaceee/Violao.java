package exemplos.interfaceee;

public class Violao extends InstrumentosDeCorda {

    public Violao(int quantidadeCordas) {
        super(quantidadeCordas = 6);
    }

    @Override
    public String emitirSom() {
        return "som de violão";
    }

}
