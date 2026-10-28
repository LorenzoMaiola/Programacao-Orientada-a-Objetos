package aquecimento.a1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Emitidas: " + Senha.getTotalEmitidas());

        Senha s1 = new Senha("Caixa");
        Senha s2 = new Senha("Gerencia");
        Senha s3 = new Senha("Caixa");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());

        try {
            Senha s4 = new Senha(null);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        Senha s4 = new Senha("Caixa");
        System.out.println(s4.toString());

        System.out.println("Emitidas: " + Senha.getTotalEmitidas());
    }
}
