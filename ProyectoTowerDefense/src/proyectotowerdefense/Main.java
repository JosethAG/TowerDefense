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
        Pila Camino2cpu = new Pila();
        Pila Camino2player = new Pila();
        InteraccionesTropa interaccion = new InteraccionesTropa();

        //Validacion para interaccion entre Camino1 CPU y Player
        if (Camino1cpu.getCima().getValor().getTipo() == 1) {
            interaccion.CombateMago(Camino1cpu, Camino1player);
        }
        if (Camino1cpu.getCima().getValor().getTipo() == 2) {
            interaccion.CombateArquero(Camino1cpu, Camino1player);
        }
        if (Camino1cpu.getCima().getValor().getTipo() == 3) {
            interaccion.CombateCaballero(Camino1cpu, Camino1player);
        }

        //Validacion para interaccion entre Camino2 CPU y Player
        if (Camino2cpu.getCima().getValor().getTipo() == 1) {
            interaccion.CombateMago(Camino2cpu, Camino2player);
        }
        if (Camino2cpu.getCima().getValor().getTipo() == 2) {
            interaccion.CombateArquero(Camino2cpu, Camino2player);
        }
        if (Camino2cpu.getCima().getValor().getTipo() == 3) {
            interaccion.CombateCaballero(Camino2cpu, Camino2player);
        }

    }

}
