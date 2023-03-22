/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotowerdefense;

/**
 *
 * @author josep
 */
public class InteraccionesTropa {
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
