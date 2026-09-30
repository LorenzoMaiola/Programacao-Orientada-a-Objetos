package exemplos.abstracao;

public class NotificacaoWPP extends NotificacaoTelefone {
    String nomeUsuario;

    public NotificacaoWPP(String titulo, String destinatario, String nomeUsuario){
        super(titulo, destinatario, nomeUsuario) ;
        this.nomeUsuario = nomeUsuario;
        

    }
    @Override
    public void disparaNotificacao() {
        System.out.println("Envio de notificação via WPP");
    }
}
