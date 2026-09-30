package exemplos.abstracao;

public class App {
    public static void main(String[] args) {
        NotificacaoAPP nApp = new NotificacaoAPP("teste", "Lorenzo");
        
        NotificacaoEmail ne = new NotificacaoEmail("teste", "Lorenzo", "lorenzo@gmail.com");

        NotificacaoSms nsms = new NotificacaoSms("teste", "Lorenzo", "lmaiola");
        
        NotificacaoWPP nw = new NotificacaoWPP("teste", "Lorenzo", "lmaiola");

        nApp.disparaNotificacao();
        ne.disparaNotificacao();
        nsms.disparaNotificacao();
        nw.disparaNotificacao();
    }
    
    
}
