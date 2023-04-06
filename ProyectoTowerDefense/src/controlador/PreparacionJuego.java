/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelo.Castillo;
import modelo.Pila;
import modelo.Tropa;
import vista.frmJuego;

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
    frmJuego frmJuego; //Se crea la referencia global 

    public void AgregarTropaUI(int cantTropaUI, int ronda, String camino, int tropa, double danho, String url) {
        cantidadActual = cantTropaUI;
        cantidadMax = ronda + 4;

        if (cantidadActual > cantidadMax) {
            return;
        }

        if (camino.equals(1)) {
            caminoPlayer1.push(new Tropa(tropa, danho, url));
        } else {
            caminoPlayer2.push(new Tropa(tropa, danho, url));
        }
        cantidadActual--;
        introUI.ActualizarCantidadUI(String.valueOf(cantidadActual));
        introUI.ActualizarCantidadUI(ronda);
        caminoPlayer1.listar();
    }

    public void RandomCPU(int ronda) {//Genera las pilas del CPU
        cantidadMax = ronda + 3; //Cantidad max de la tropa
        //int cantCaminoMax = Integer.parseInt(Double.toString(cantidadMax * 0.75)); //Cantidad max de tropas por camino
        double calculo = cantidadMax * 0.75; //Cantidad max de tropas por camino
        int cantCaminoMax =  (int)calculo ;
        Random azar = new Random(); //Instanciamos Random
        int numPush = 0; //cantidad de push posibles
        int camino;
        int cantCamino1 = 0; //Cantidad de tropas colocadas camino 1
        int cantCamino2 = 0; //cantidad de tropas colocadas camino 2

        while (cantidadMax >= numPush) { // Ciclo para validar si tenemos push disponibles
            camino = (azar.nextInt(2) + 1); // generamos un numero aleatorio para el camino
            int tropa = (azar.nextInt(3) + 1); // generamos el numero de tropa
            if (camino == 1 && cantCaminoMax >= cantCamino1) { // validamos cual camino es y si esta al 75% ya

                switch (tropa) {
                    case 1:
                        caminoCpu1.push(new Tropa(tropa, 1.5, "/imagenes/Mago-Verde-x54.png")); //push a la pila
                        cantCamino1++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                    case 2:
                        caminoCpu1.push(new Tropa(tropa, 1, "/imagenes/Arquera-Verde-x59.png"));
                        cantCamino1++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                    case 3:
                        caminoCpu1.push(new Tropa(tropa, 2, "/imagenes/caballero-Verde-85x90.png"));
                        cantCamino1++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                }

            } else if (camino == 2 && cantCaminoMax >= cantCamino2) {
                switch (tropa) {
                    case 1:
                        caminoCpu2.push(new Tropa(tropa, 1.5, "/imagenes/Mago-Verde-x54.png")); //push a la pila
                        numPush++; //Incrementamos la cantidad de push hechos
                        cantCamino2++;
                        break;
                    case 2:
                        caminoCpu2.push(new Tropa(tropa, 1, "/imagenes/Arquera-Verde-x59.png"));
                        cantCamino1++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos

                        break;
                    case 3:
                        caminoCpu2.push(new Tropa(tropa, 2, "/imagenes/caballero-Verde-85x90.png"));
                        cantCamino1++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                }

            }
        }
    }

    public void ActualizarIconoCam1() {

        Icon iconoPlayer1;
        iconoPlayer1 = new ImageIcon(getClass().getResource(caminoPlayer1.getCima().getValor().getUrl()));
        frmJuego.lblTropaPlayer1.setIcon(iconoPlayer1);
        frmJuego.repaint();
        Icon iconoCPU1;
        iconoCPU1 = new ImageIcon(getClass().getResource(caminoCpu1.getCima().getValor().getUrl()));
        frmJuego.lblTropa1CPU.setIcon(iconoCPU1);

        frmJuego.repaint();

    }

    public void ActualizarIconoCam2() {

        Icon iconoPlayer2;
        iconoPlayer2 = new ImageIcon(getClass().getResource(caminoPlayer2.getCima().getValor().getUrl()));
        frmJuego.lblTropaPlayer2.setIcon(iconoPlayer2);
        frmJuego.repaint();
        Icon iconoCPU2;
        iconoCPU2 = new ImageIcon(getClass().getResource(caminoCpu2.getCima().getValor().getUrl()));
        frmJuego.lblTropa2CPU.setIcon(iconoCPU2);

        frmJuego.repaint();

    }

    public void IniciaJuego() {
        Hilo hilo = new Hilo(frmJuego); //Se hace la instancia con la clase hilo y se le pasa un this
        hilo.start(); //Es un metodo que pertenece a la clase Thread de la cual hilo esta heredando y se usa para llamar al metodo ejecutar de la clase hilo e iniciar el hilo

    }

}
