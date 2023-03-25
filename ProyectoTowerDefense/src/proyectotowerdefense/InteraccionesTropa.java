/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotowerdefense;

import javax.swing.JOptionPane;

/**
 *
 * @author Equipo4
 */
public class InteraccionesTropa {
    
    public void Seleccion(Pila pila1, Pila pila2, int ronda){
        int numTropas = ronda + 4;
        int numPush = 0;
        int camino;
        while(numTropas < numPush){
            numPush++;
            camino = Integer.valueOf(JOptionPane.showInputDialog("Camino al que desea ingresar la tropa [1] o [2]"));
            if(camino == 1){
                int tropa = Integer.valueOf(JOptionPane.showInputDialog("Cual tropa desea colocar [1] Mago [2] Arquero [3] Caballero"));
                pila1.push(new Tropa(tropa));
            } else {
                int tropa = Integer.valueOf(JOptionPane.showInputDialog("Cual tropa desea colocar [1] Mago [2] Arquero [3] Caballero"));
                pila2.push(new Tropa(tropa));
            }
        }
    }
    
    public void RandomCPU(){
        
    }
    
    public void CombateMago (Pila pilaCPU, Pila pilaPlayer){
        if (pilaCPU.getCima().getValor().getTipo() == 1 && pilaPlayer.getCima().getValor().getTipo() == 1) { //mago vs mago
            pilaCPU.pop();
            pilaPlayer.pop();
        } else if (pilaCPU.getCima().getValor().getTipo() == 1 && pilaPlayer.getCima().getValor().getTipo() == 2){ //mago vs arquero
            pilaCPU.pop();
        } else if (pilaCPU.getCima().getValor().getTipo() == 1 && pilaPlayer.getCima().getValor().getTipo() == 3){ //mago vs caballero
            pilaPlayer.pop();
        } else {
            System.out.println("avanza al castillo");
        }
    }

    public void CombateArquero (Pila pilaCPU, Pila pilaPlayer){
        if (pilaCPU.getCima().getValor().getTipo() == 2 && pilaPlayer.getCima().getValor().getTipo() == 2) { //Arquero vs Arquero
            pilaCPU.pop();
            pilaPlayer.pop();
        } else if (pilaCPU.getCima().getValor().getTipo() == 2 && pilaPlayer.getCima().getValor().getTipo() == 1){ //Arquero vs Mago
            pilaPlayer.pop();
        } else if (pilaCPU.getCima().getValor().getTipo() == 2 && pilaPlayer.getCima().getValor().getTipo() == 3){ //Arquero vs caballero
            pilaCPU.pop();
        } else {
            System.out.println("avanza al castillo");
        }
    }

    public void CombateCaballero (Pila pilaCPU, Pila pilaPlayer){
        if (pilaCPU.getCima().getValor().getTipo() == 3 && pilaPlayer.getCima().getValor().getTipo() == 3) { //Caballero vs Caballero
            pilaCPU.pop();
            pilaPlayer.pop();
        } else if (pilaCPU.getCima().getValor().getTipo() == 3 && pilaPlayer.getCima().getValor().getTipo() == 1){ //Callero vs Mago
            pilaCPU.pop();
        } else if (pilaCPU.getCima().getValor().getTipo() == 3 && pilaPlayer.getCima().getValor().getTipo() == 2){ //Caballero vs Arquero
            pilaPlayer.pop();
        } else {
            System.out.println("avanza al castillo");
        }
    }
}
