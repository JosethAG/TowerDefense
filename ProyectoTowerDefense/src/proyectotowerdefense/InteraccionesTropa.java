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
    private Nodo place;
    public static void Mago (int tipo1, int tipo2, Nodo place){
        if (tipo1 == 1 && tipo2 == 1) { //mago vs mago
        place = null;
    } else if (tipo1 == 1 && tipo2 == 2){ //mago vs arquero
        place = tipo2;
    } else if (tipo1 == 2 && tipo2 == 1){ //arquero vs mago
        place = tipo1;
    } else if (tipo1 == 1 && tipo2 == 3){ //mago vs caballero
        place = tipo1;
    } else if (tipo1 == 3 && tipo2 == 1){ //caballero vs mago
        place = tipo2;
    }
    }
}
