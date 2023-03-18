package proyectotowerdefense;

public class Pila {
    private NodoPila cima;
    private int largo;

    public Pila(){
        this.cima = null;
        this.largo = 0;
    }

    public boolean Vacia(){return cima == null;}

    public int tamanio(){return this.largo;}

    public void push(Tropa valor){
        NodoPila newNode = new NodoPila();
        newNode.setValor(valor);

        if(this.Vacia()){
            this.cima = newNode;
        }
        else{
            newNode.setSiguiente(this.cima);
            this.cima = newNode;
        }
        this.largo++;
    }

    public void pop(){
        if (!Vacia()){
            //Asigna como primer node al siguiente de la pila
            this.cima = this.cima.getSiguiente();
            //Decrementa el contador del tamaño de la pila
            this.largo--;
        }
    }
}
