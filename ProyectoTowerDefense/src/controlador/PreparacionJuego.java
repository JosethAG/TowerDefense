/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Random;
import proyectotowerdefense.Castillo;
import proyectotowerdefense.Pila;
import proyectotowerdefense.Tropa;

/**
 *
 * @author araya
 */
public class PreparacionJuego {

    private int cantidadActual;
    private int cantidadMax;
    Pila caminoCpu1 = new Pila();
    Pila caminoPlayer1 = new Pila();
    Pila caminoCpu2 = new Pila();
    Pila caminoPlayer2 = new Pila();
    Castillo castilloCPU = new Castillo(1, 10, 1);
    Castillo castilloPlayer = new Castillo(2, 10, 2);
    InteraccionesTropa interaccion = new InteraccionesTropa();
    InteraccionUI introUI = new InteraccionUI();

    public void AgregarTropaUI(int cantTropaUI, int ronda, String camino, int tropa) {
        cantidadActual = cantTropaUI;
        cantidadMax = ronda + 4;

        if (cantidadActual > cantidadMax) {
            return;
        }

        if (camino.equals("1")) {
            caminoPlayer1.push(new Tropa(tropa));
        } else {
            caminoPlayer2.push(new Tropa(tropa));
        }
        cantidadActual--;
        introUI.ActualizarCantidadUI(String.valueOf(cantidadActual));
        introUI.ActualizarCantidadUI(ronda);
        caminoPlayer1.listar();
    }
   
    public void RandomCPU(int ronda) {//Genera las pilas del CPU
        cantidadMax = ronda + 3; //Cantidad max de la tropa
        int cantCaminoMax = Integer.parseInt(Double.toString(cantidadMax*0.75)); //Cantidad max de tropas por camino
        Random azar = new Random(); //Instanciamos Random
        int numPush = 0; //cantidad de push posibles
        int camino; 
        int cantCamino1 = 0; //Cantidad de tropas colocadas camino 1
        int cantCamino2 = 0; //cantidad de tropas colocadas camino 2
        
        while (cantidadMax >= numPush) { // Ciclo para validar si tenemos push disponibles
            camino = (azar.nextInt(2) + 1); // generamos un numero aleatorio para el camino
            if (camino == 1 && cantCaminoMax >= cantCamino1) { // validamos cual camino es y si esta al 75% ya
                int tropa = (azar.nextInt(3) + 1); // generamos el numero de tropa
                caminoCpu1.push(new Tropa(tropa)); //push a la pila
                cantCamino1++; // incrementamos las tropas agregadas
                numPush++; //Incrementamos la cantidad de push hechos
            } else if (camino == 2 && cantCaminoMax >= cantCamino2){ 
                int tropa = (azar.nextInt(3) + 1);
                caminoCpu2.push(new Tropa(tropa));
                cantCamino2++;
                numPush++;
            } 
        }
    }
    
    
}
