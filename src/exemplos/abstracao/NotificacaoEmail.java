package exemplos.abstracao;

public class NotificacaoEmail extends Notificacao {
    String email;

    public NotificacaoEmail(String titulo, String destinatario, String email) {
        super(titulo, destinatario);
        this.email = email;
    }

    @Override
    public void disparaNotificacao() {
        System.out.println("Envio de notificação via Email");

    }

}