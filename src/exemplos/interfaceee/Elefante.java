package exemplos.interfaceee;

public class Elefante implements Animal{

    @Override
    public String emitirSom() {
        return "brrrrr";
    }

    @Override
    public int getQuantidadePatas() {
        return 4;
    }
        
}
