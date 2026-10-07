package exemplos.interfaceee;

public interface Animal extends EmitirSom {

    default boolean isSelvagem(){
        return true;
    }

    int getQuantidadePatas();
}
