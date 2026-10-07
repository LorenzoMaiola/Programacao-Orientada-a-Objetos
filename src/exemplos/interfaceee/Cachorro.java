package exemplos.interfaceee;

public class Cachorro implements Animal, Sentimento{
    
    @Override 
    public String emitirSom(){
        return "au au";
    }

    @Override
    public int getQuantidadePatas() {
        return 4;
    }

    @Override
    public String getTipoSentimento() {
        return "Alegria";
    }
}
