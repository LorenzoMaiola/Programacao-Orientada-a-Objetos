package exemplos.abstracao;

public class NotificacaoAPP extends Notificacao {

    private int idUsuario;

    public NotificacaoAPP(String titulo, String destinatario){
        super(titulo, destinatario);
        this.idUsuario = idUsuario;
    }


    @Override
    public void disparaNotificacao() {
        System.out.println("Envio de notificação via APP");
    
    }

}
