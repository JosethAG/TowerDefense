/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotowerdefense;

/**
 *
 * @author Angelo
 */
public class NodoCastillo {
    
        
    private Castillo dato;
    private NodoCastillo next;

    public NodoCastillo(Castillo dato) {
        this.dato = dato;
    }

    public Castillo getDato() {
        return dato;
    }

    public void setDato(Castillo dato) {
        this.dato = dato;
    }

    public NodoCastillo getNext() {
        return next;
    }

    public void setNext(NodoCastillo next) {
        this.next = next;
    }
    
    
}
