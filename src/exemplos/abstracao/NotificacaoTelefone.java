package exemplos.abstracao;

public abstract class NotificacaoTelefone extends Notificacao{
    private String telefone;
    
    public NotificacaoTelefone(String titulo, String destinatario, String telefone){
        super(titulo, destinatario);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
}
