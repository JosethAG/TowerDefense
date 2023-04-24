package modelo;

/**
 * @author Grupo 4
 */
public class Lista {
    private NodoCastillo cabeza;
    
    public void inserta(Castillo c){
        if(cabeza==null){
            cabeza = new NodoCastillo(c);
        }else if (c.getId() < cabeza.getDato().getId()){
            NodoCastillo aux = new NodoCastillo(c);
            aux.setNext(cabeza);
            cabeza = aux;
        }else if(cabeza.getNext()==null){
            cabeza.setNext(new NodoCastillo(c));
        }else{
            NodoCastillo aux = cabeza;
            while(aux.getNext() != null && aux.getNext().getDato().getId() < c.getId()){
                aux=aux.getNext();
        }
            NodoCastillo temp = new NodoCastillo(c);
            temp.setNext(aux.getNext());
            aux.setNext(temp);
        }
    }
    public boolean existe(int id){
        boolean esta = false;
        if(cabeza != null){
            NodoCastillo aux = cabeza;
            
            while(aux != null && aux.getDato().getId() < id){
                aux = aux.getNext();
            }
            esta = (aux != null && aux.getDato().getId()==id);
        }
        return esta;
    }
    public void modifica(Castillo c){
        if(cabeza != null){
            NodoCastillo aux = cabeza;
            while(aux != null && aux.getDato().getId() < c.getId()){
            aux = aux.getNext();
        }
            if(aux != null && aux.getDato().getId()==c.getId()){
                aux.getDato().setVida(c.getVida());
            }
        }
    }
    public void elimina(int id){
        if(cabeza != null){
            if(cabeza.getDato().getId()==id)
            {
                cabeza = cabeza.getNext();
            }
            else{
                NodoCastillo aux = cabeza;
                while(aux.getNext() != null && 
                        aux.getNext().getDato().getId() < id){
                    aux = aux.getNext();
                }
                if(aux.getNext() != null &&
                        aux.getNext().getDato().getId() < id){
                    aux.setNext(aux.getNext().getNext());
                }
            }
        }
    }
    public Castillo extrae(int id){
        Castillo c = null;
        if(cabeza != null){
            if(cabeza.getDato().getId()==id){
                cabeza = cabeza.getNext();
            }else{
                NodoCastillo aux = cabeza;
                while(aux.getNext() != null && aux.getNext().getDato().getId() < id){
                    aux = aux.getNext();
                }
                if (aux.getNext() != null && aux.getNext().getDato().getId()==id){
                    c = aux.getNext().getDato();
                    aux.setNext(aux.getNext().getNext());
                }
            }
        }
        return c;
    }
}
