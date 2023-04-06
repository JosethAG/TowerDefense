package modelo;

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

    public NodoPila getCima() {
        return cima;
    }
    
    public void listar() {
        // Crea una copia de la pila.
        NodoPila aux = cima; //Se llama a la clase nodo y se le pone un nombre al objeto que es aux y se le dice que ese abojeto va a ser igual a la cima 

        // Recorre la pila hasta el ultimo node.
        while (aux != null) {
            System.out.println("|\t" + aux.getValor().getTipo() + "\n" + aux.getValor().getDanho() + "\n" + aux.getValor().getUrl() + "\t|");
            System.out.println("-----------------");
            aux = aux.getSiguiente();
        }
    }
}
