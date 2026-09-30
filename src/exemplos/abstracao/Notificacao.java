package exemplos.abstracao;

public abstract class Notificacao {
    private String titulo;
    private String destinatario;

    public Notificacao(String titulo, String destinatario){
        this.destinatario =destinatario;
        this.titulo =  titulo; 
    }


    public abstract void disparaNotificacao();
    
}
