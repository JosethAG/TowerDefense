package modelo;

public class NodoPila {
    private Tropa valor;
    private NodoPila siguiente;

    public NodoPila(){
        this.valor = null;
        this.siguiente = null;
    }

    public Tropa getValor() {
        return valor;
    }

    public void setValor(Tropa valor) {
        this.valor = valor;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}
