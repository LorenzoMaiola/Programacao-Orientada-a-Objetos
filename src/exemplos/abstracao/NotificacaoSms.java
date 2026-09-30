package exemplos.abstracao;

public class NotificacaoSms extends NotificacaoTelefone{
    
    String nomeUsuario;

    public NotificacaoSms(String titulo, String destinatario, String nomeUsuario){
        super(titulo, destinatario, nomeUsuario) ;
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public void disparaNotificacao() {
        System.out.println("Envio de notificação via SMS ");
        
    }
    
}
