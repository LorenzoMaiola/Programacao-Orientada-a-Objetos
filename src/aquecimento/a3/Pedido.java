package aquecimento.a3;

// Versão 2 
public class Pedido {
    private Endereco entrega;
    private Cliente comprador;

    public Pedido(Cliente comprador, String rua, int numero) {
        entrega = new Endereco();
        setComprador(comprador);
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public void setRuaEntrega(String rua) {
        this.entrega.setRua(rua);
        ;
    }

    public void setNumeroEntrega(int numero) {
        this.entrega.setNumero(numero);
    }

    public String getRuaEntrega() {
        return this.entrega.getRua();
    }

    public int getNumeroEntrega() {
        return this.entrega.getNumero();
    }

    public Cliente getComprador() {
        return comprador;
    }

}
