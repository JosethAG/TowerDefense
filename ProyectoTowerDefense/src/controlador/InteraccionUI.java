/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import proyectotowerdefense.Castillo;
import proyectotowerdefense.InteraccionesTropa;
import proyectotowerdefense.Main;
import proyectotowerdefense.Pila;
import proyectotowerdefense.Tropa;

/**
 *
 * @author Administrador
 */
public class InteraccionUI {
    private int cantidadActual;
    private int cantidadMax;
    Pila caminoCpu1 = new Pila();
    Pila caminoPlayer1 = new Pila();
    Pila caminoCpu2 = new Pila();
    Pila caminoPlayer2 = new Pila();
    Castillo castilloCPU = new Castillo(1, 10, 1);
    Castillo castilloPlayer = new Castillo(2, 10, 2);
    InteraccionesTropa interaccion = new InteraccionesTropa();

    public void AgregarTropaUI(int cantTropaUI, int ronda, String camino, int tropa){
        cantidadActual = cantTropaUI;
        cantidadMax = ronda + 4;
        
        if(cantidadActual > cantidadMax){
            return;
        }
        
        if(camino == "1"){
            caminoPlayer1.push(new Tropa(tropa));
        } else {
            caminoPlayer2.push(new Tropa(tropa));
        }
        cantidadActual--;
        ActualizarCantidadUI(String.valueOf(cantidadActual));
        ActualizarCantidadUI(ronda);
    }
    
    public String ActualizarCantidadUI(String cantTropaUI){
        return cantTropaUI;
        
    }
    
    public String ActualizarCantidadUI(int ronda){
        
        return String.valueOf(ronda);
        
    }
}
