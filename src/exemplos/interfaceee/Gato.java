package exemplos.interfaceee;

public class Gato implements Animal, Sentimento {

    @Override
    public String emitirSom() {
        return "Maiu";
    }

    @Override
    public String getTipoSentimento() {
        return "Carente";
    }

    @Override
    public int getQuantidadePatas() {
        return 4;
    }
}