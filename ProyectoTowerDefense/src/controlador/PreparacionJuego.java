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
    Castillo castilloCPU = new Castillo(1, 10, 1);
    Castillo castilloPlayer = new Castillo(2, 10, 2);
    InteraccionUI introUI = new InteraccionUI();
    frmJuego frmJuego; //Se crea la referencia global 
    Icon iconoPlayer1;
    Icon iconoCPU1;

    public void AgregarTropaUI(int cantTropaUI, int ronda, String camino, int tropa, double danho, String url) {
        cantidadActual = cantTropaUI;
        cantidadMax = ronda + 4;

        if (cantidadActual > cantidadMax) {
            return;
        }

        if (camino.equals("1")) {
            caminoPlayer1.push(new Tropa(tropa, danho, url));
        }
        cantidadActual--;
        introUI.ActualizarCantidadUI(String.valueOf(cantidadActual));
        introUI.ActualizarCantidadUI(ronda);
    }

    public void RandomCPU(int ronda) {//Genera las pilas del CPU
        cantidadMax = ronda + 3; //Cantidad max de la tropa
        Random azar = new Random(); //Instanciamos Random
        int numPush = 0; //cantidad de push posibles
        int cantCamino1 = 0; //Cantidad de tropas colocadas camino 1

        while (cantidadMax >= numPush) { // Ciclo para validar si tenemos push disponibles
            int tropa = (azar.nextInt(3) + 1); // generamos el numero de tropa

            switch (tropa) {
                case 1:
                    caminoCpu1.push(new Tropa(tropa, 1.5, "/img/Mago-rojo-x54.png")); //push a la pila
                    cantCamino1++; // incrementamos las tropas agregadas
                    numPush++; //Incrementamos la cantidad de push hechos
                    break;
                case 2:
                    caminoCpu1.push(new Tropa(tropa, 1, "/img/Arquera-Roja-x59.png"));
                    cantCamino1++; // incrementamos las tropas agregadas
                    numPush++; //Incrementamos la cantidad de push hechos
                    break;
                case 3:
                    caminoCpu1.push(new Tropa(tropa, 10, "/img/caballero-Rojo-x59.png"));
                    cantCamino1++; // incrementamos las tropas agregadas
                    numPush++; //Incrementamos la cantidad de push hechos
                    break;

            }
        }
    }

    public void ActualizarIconoCam() {

        if (caminoPlayer1.Vacia() != true) {
            iconoPlayer1 = new ImageIcon(getClass().getResource(caminoPlayer1.getCima().getValor().getUrl()));
            frmJuego.lblTropaPlayer1.setIcon(iconoPlayer1);
        }
        if (caminoCpu1.Vacia() != true) {
            iconoCPU1 = new ImageIcon(getClass().getResource(caminoCpu1.getCima().getValor().getUrl()));
            frmJuego.lblTropa1CPU.setIcon(iconoCPU1);
        }

        if (caminoPlayer1.Vacia()) {
            frmJuego.lblTropaPlayer1.setLocation(10000, 515);
            frmJuego.lblTropaPlayer1.setVisible(false);
        }

        if (caminoCpu1.Vacia()) {
            frmJuego.lblTropa1CPU.setLocation(-10000, 515);
            frmJuego.lblTropa1CPU.setVisible(false);

        }
    }

    public void MostrarTropasCPU() {
        Icon iconoCPU;
        iconoCPU = new ImageIcon(getClass().getResource(
                caminoCpu1.getCima().getValor().getUrl()));
        frmJuego.lblCPU1.setIcon(iconoCPU);

        if (caminoCpu1.tamanio() >= 3) {
            iconoCPU = new ImageIcon(getClass().getResource(
                    caminoCpu1.getCima().getValor().getUrl()));
            frmJuego.lblCPU1.setIcon(iconoCPU);

            iconoCPU = new ImageIcon(getClass().getResource(
                    caminoCpu1.getCima().getSiguiente().getValor().getUrl()));
            frmJuego.lblCPU2.setIcon(iconoCPU);

            iconoCPU = new ImageIcon(getClass().getResource(
                    caminoCpu1.getCima().getSiguiente().getSiguiente().getValor().getUrl()));
            frmJuego.lblCPU3.setIcon(iconoCPU);
        }
    }

    public void IniciaJuego() {
        Hilo hilo = new Hilo(frmJuego); //Se hace la instancia con la clase hilo y se le pasa un this
        hilo.start(); //Es un metodo que pertenece a la clase Thread de la cual hilo esta heredando y se usa para llamar al metodo ejecutar de la clase hilo e iniciar el hilo

    }

    public void lista() {
        caminoCpu1.listar();
        System.out.println("------------------------");
    }

    public int verificaDueloTropas() { //Se valida en cuál camino es el duelo
        //Choque entre camino 1
        if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblTropa1CPU.getX() + 61)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {

            return 1;

        }
        return 0;

    }

    public void Combate(int camino) {
        int tropaCPU = 0;
        int tropaPlayer = 0;
        if (camino == 1) {

            if (caminoCpu1.Vacia() != true && caminoPlayer1.Vacia() != true) {
                tropaCPU = caminoCpu1.getCima().getValor().getTipo();
                tropaPlayer = caminoPlayer1.getCima().getValor().getTipo();

                if (tropaCPU == 1 && tropaPlayer == 1) { //mago vs mago
                    caminoCpu1.pop();
                    caminoPlayer1.pop();
                } else if (tropaCPU == 1 && tropaPlayer == 2) { //mago vs arquero
                    caminoCpu1.pop();
                } else if (tropaCPU == 1 && tropaPlayer == 3) { //mago vs caballero
                    caminoPlayer1.pop();
                } else if (tropaCPU == 2 && tropaPlayer == 2) { //Arquero vs Arquero
                    caminoCpu1.pop();
                    caminoPlayer1.pop();
                } else if (tropaCPU == 2 && tropaPlayer == 1) { //Arquero vs Mago
                    caminoPlayer1.pop();
                } else if (tropaCPU == 2 && tropaPlayer == 3) { //Arquero vs caballero
                    caminoCpu1.pop();
                } else if (tropaCPU == 3 && tropaPlayer == 3) { //Caballero vs Caballero
                    caminoCpu1.pop();
                    caminoPlayer1.pop();
                } else if (tropaCPU == 3 && tropaPlayer == 1) { //Callero vs Mago
                    caminoCpu1.pop();
                } else //Caballero vs Arquero
                {
                    caminoPlayer1.pop();
                }
            }

        }
    }

    public int verificaDueloCastillo() { //Validacion para verificar si hubo algun enfrentamiento contra el castillo
        //Choque castillo Player en camino 1 
        if (frmJuego.lblTropa1CPU.getX() >= frmJuego.lblCastilloPlayer.getX() - 40) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Choco Castillo Player Camino 1");
            return 1; //Retorna 1 si hubo un choque en el castillo del Player en el camino 1
        } // Choque entre camino 1 castillo CPU
        else if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblCastilloCPU.getX() + 307)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Choco Castillo CPU Camino 1");
            return 2; //Retorna 2 si hubo un choque en el castillo del CPU en el camino 1
        }

        return 0;

    }

    public void verificaCastilloDestruido() {
        if (castilloPlayer.getVida() <= 0) {
            introUI.ActualizaVidaCastillos(1, 0);
//            frmPreparacion.apagaHilo();

        } else if (castilloCPU.getVida() <= 0) {
            introUI.ActualizaVidaCastillos(2, 0);
//            frmPreparacion.apagaHilo();

        }
    }

    public void ReiniciaPosicionesCam() {
        if (caminoCpu1.Vacia() != true && caminoPlayer1.Vacia() != true) {
            frmJuego.lblTropa1CPU.setLocation(360, 515);
            frmJuego.lblTropaPlayer1.setLocation(1210, 515);

        } else if (caminoCpu1.Vacia() && caminoPlayer1.Vacia()) {
            frmJuego.lblTropa1CPU.setLocation(-10000, 515);
            frmJuego.lblTropaPlayer1.setLocation(10000, 515);
            
        } else if (caminoPlayer1.Vacia()) {
            frmJuego.lblTropaPlayer1.setLocation(10000, 515);

        } else {
            frmJuego.lblTropa1CPU.setLocation(-3000, 515);
        }

        if (verificaDueloCastillo() == 1 || verificaDueloCastillo() == 2) {
            if (!caminoCpu1.Vacia() && !caminoPlayer1.Vacia()) {
                frmJuego.lblTropa1CPU.setLocation(360, 515);
                frmJuego.lblTropaPlayer1.setLocation(1210, 515);

            } else if (caminoCpu1.Vacia() && caminoPlayer1.Vacia()) {
                frmJuego.lblTropa1CPU.setLocation(-10000, 515);
                frmJuego.lblTropaPlayer1.setLocation(10000, 515);

            } else if (caminoPlayer1.Vacia()) {
                frmJuego.lblTropa1CPU.setLocation(360, 515);
                frmJuego.lblTropaPlayer1.setLocation(10000, 515);

            } else {
                frmJuego.lblTropa1CPU.setLocation(-10000, 515);
                frmJuego.lblTropaPlayer1.setLocation(1210, 515);
            }

        }
    }

    public double DevolverDanio(int danio) {
        switch (danio) {
            case 1:
                return Double.valueOf(caminoCpu1.getCima().getValor().getDanho());
            case 2:
                return Double.valueOf(caminoPlayer1.getCima().getValor().getDanho());
            default:
                return 0;
        }
    }

    public void EliminarTropaCastillo(int camino) {
        switch (camino) {
            case 1:
                caminoCpu1.pop();
                break;
            case 2:
                caminoPlayer1.pop();
                break;
        }
    }
    
    public boolean CambioRonda(){
        if (caminoPlayer1.Vacia() && caminoCpu1.Vacia()) {
            int numR = Integer.parseInt(frmJuego.lblNumRonda.getText()) + 1;
            frmJuego.lblNumRonda.setText(String.valueOf(numR));
            frmJuego.lblCantidadTropas.setText(String.valueOf(numR + 4));
            frmJuego.lblTropa1CPU.setLocation(360, 515);
            frmJuego.lblTropaPlayer1.setLocation(1210, 515);
            return true;
        }
        return false;
    }
    
    

    public Castillo getCastilloCPU() {
        return castilloCPU;
    }

    public void setCastilloCPU(Castillo castilloCPU) {
        this.castilloCPU = castilloCPU;
    }

    public Castillo getCastilloPlayer() {
        return castilloPlayer;
    }

    public void setCastilloPlayer(Castillo castilloPlayer) {
        this.castilloPlayer = castilloPlayer;
    }

}
