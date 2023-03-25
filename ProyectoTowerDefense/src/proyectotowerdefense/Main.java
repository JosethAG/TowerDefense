/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotowerdefense;

import javax.swing.JOptionPane;


/**
 *
 * @author Equipo4
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
        Castillo castilloCPU = new Castillo(1, 10, 1);
        Castillo castilloPlayer = new Castillo(2, 10, 2);
        int ronda = 1;
        boolean repetir = true;
        //Ciclo Principal
        while(repetir){
            //Menu
            //Ciclo juego
            while(castilloCPU.getVida() > 0 || castilloPlayer.getVida() > 0){
                //preparacion
                interaccion.Seleccion(Camino1player, Camino2player, ronda);
                

                //inicio
                //interacciones
                ronda++;
            }
        }
        
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
