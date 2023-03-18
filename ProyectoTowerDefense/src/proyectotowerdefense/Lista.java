/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotowerdefense;

/**
 *
 * @author Usuario
 */
public class Lista {
    private Nodo cabeza;
    
    public void inserta(Persona p){
        if(cabeza==null){
            cabeza = new Nodo(p);
        }else if (p.getId()<cabeza.getDato.getId()){
            Nodo aux = new Nodo(p);
            aux.setNext(cabeza);
            cabeza = aux;
        }else if(cabeza.getNext()==null){
            cabeza.setNext(new Nodo(p));
        }else{
            Nodo aux = cabeza;
            while(aux.getNext() != null && aux.getNext().getDato().getId() < p.getId()){
                aux=aux.getNext();
        }
            Nodo temp = new Nodo(p);
            temp.setNext(aux.getNext());
            aux.setNext(temp);
        }
    }
    public boolean existe(int id){
        boolean esta = false;
        if(cabeza != null){
            Nodo aux = cabeza;
            
            while(aux != null && aux.getDato().getId() < id){
                aux = aux.getNext();
            }
            esta = (aux != null && aux:getDato().getId()==id);
        }
        return esta;
    }
    public void modifica(persona p){
        if(cabeza != null){
            Nodo aux = cabeza;
            while(aux != null && aux.getDato().getId() < p.getId()){
            aux = aux.getNext();
        }
            if(aux != null && aux.getDato().getId()==p.getId()){
                aux.getDato().setNombre(p.getNombre());
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
                Nodo aux = cabeza;
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
    public Persona extrae(int id){
        Persona p = null;
        if(cabeza != null){
            if(cabeza.getDato().getId()==id){
                cabeza = cabeza.getNext();
            }else{
                Nodo aux = cabeza;
                while(aux.getNext() != null && aux.getNext().getDato().getId() < id){
                    aux = aux.getNext();
                }
                if (aux.getNext() != null && aux.getNext().getDato().getId()==id){
                    p = aux.getNext().getDato();
                    aux.setNext(aux.getNext().getNext());
                }
            }
        }
        return p;
    }
}
