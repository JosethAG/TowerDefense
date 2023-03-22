/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotowerdefense;

/**
 *
 * @author Angelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila Camino1cpu = new Pila();
        Pila Camino1player = new Pila();
        InteraccionesTropa interaccion = new InteraccionesTropa();
        interaccion.CombateMago(Camino1cpu, Camino1player);

    }
    
}
