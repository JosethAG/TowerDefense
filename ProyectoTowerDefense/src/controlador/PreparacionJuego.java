/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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

        if (camino.equals("1")) {
            caminoPlayer1.push(new Tropa(tropa, danho, url));
        } else {
            caminoPlayer2.push(new Tropa(tropa, danho, url));
        }
        cantidadActual--;
        introUI.ActualizarCantidadUI(String.valueOf(cantidadActual));
        introUI.ActualizarCantidadUI(ronda);
    }

    public void RandomCPU(int ronda) {//Genera las pilas del CPU
        cantidadMax = ronda + 3; //Cantidad max de la tropa
        //int cantCaminoMax = Integer.parseInt(Double.toString(cantidadMax * 0.75)); //Cantidad max de tropas por camino
        double calculo = cantidadMax * 0.75; //Cantidad max de tropas por camino
        int cantCaminoMax = (int) calculo;
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
                        caminoCpu1.push(new Tropa(tropa, 2, "/img/caballero-Rojo-x59.png"));
                        cantCamino1++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                }

            } else if (camino == 2 && cantCaminoMax >= cantCamino2) {
                switch (tropa) {
                    case 1:
                        caminoCpu2.push(new Tropa(tropa, 1.5, "/img/Mago-rojo-x54.png")); //push a la pila
                        cantCamino2++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                    case 2:
                        caminoCpu2.push(new Tropa(tropa, 1, "/img/Arquera-Roja-x59.png"));
                        cantCamino2++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                    case 3:
                        caminoCpu2.push(new Tropa(tropa, 2, "/img/caballero-Rojo-x59.png"));
                        cantCamino2++; // incrementamos las tropas agregadas
                        numPush++; //Incrementamos la cantidad de push hechos
                        break;
                }

            }
        }
    }

    public void ActualizarIconoCam() {

        Icon iconoPlayer1;
        iconoPlayer1 = new ImageIcon(getClass().getResource(caminoPlayer1.getCima().getValor().getUrl()));
        frmJuego.lblTropaPlayer1.setIcon(iconoPlayer1);
        Icon iconoCPU1;
        iconoCPU1 = new ImageIcon(getClass().getResource(caminoCpu1.getCima().getValor().getUrl()));
        frmJuego.lblTropa1CPU.setIcon(iconoCPU1);

        Icon iconoPlayer2;
        iconoPlayer2 = new ImageIcon(getClass().getResource(
                caminoPlayer2.getCima().getValor().getUrl()));
        frmJuego.lblTropaPlayer2.setIcon(iconoPlayer2);
        Icon iconoCPU2;
        iconoCPU2 = new ImageIcon(getClass().getResource(
                caminoCpu2.getCima().getValor().getUrl()));
        frmJuego.lblTropa2CPU.setIcon(iconoCPU2);

        //   frmJuego.repaint();
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
        } else {
            iconoCPU = new ImageIcon(getClass().getResource(
                    caminoCpu2.getCima().getValor().getUrl()));
            frmJuego.lblCPU1.setIcon(iconoCPU);

            iconoCPU = new ImageIcon(getClass().getResource(
                    caminoCpu2.getCima().getSiguiente().getValor().getUrl()));
            frmJuego.lblCPU2.setIcon(iconoCPU);

            iconoCPU = new ImageIcon(getClass().getResource(
                    caminoCpu2.getCima().getSiguiente().getSiguiente().getValor().getUrl()));
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
        caminoCpu2.listar();
    }

    public void moverTropas() {
        //Lo que me permite es que cada vez que se llame en el hilo toma las posiciones de las tropas y las mueve
        //  lblTropa1CPU.setLocation(lblTropa1CPU.getX() + 5, lblTropa1CPU.getY());
        // lblTropaPlayer1.setLocation(lblTropaPlayer1.getX() - 5, lblTropaPlayer1.getY());

        frmJuego.lblTropa2CPU.setLocation(frmJuego.lblTropa2CPU.getX() + 5, frmJuego.lblTropa2CPU.getY());
        //lblTropaPlayer2.setLocation(lblTropaPlayer2.getX() - 2, lblTropaPlayer2.getY());

    }

    public int verificaDueloTropas() { //Se valida en cuál camino es el duelo
        //Choque entre camino 1
        if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblTropa1CPU.getX() + 134)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
//            Combate(caminoCpu1, caminoPlayer1);
            System.out.println("Duelo camino 1");
            return 1;

        }

        // Choque entre camino 2
        if (frmJuego.lblTropaPlayer1.getX() < (frmJuego.lblTropa2CPU.getX() + 61)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
//            Combate();
            System.out.println("Duelo camino 2");
            return 2;

        }
        return 0;

    }

//    public void Combate(int camino) {
//        if(camino == 1){
//            int tropaCPU = .getCima().getValor().getTipo();
//            int tropaPlayer = pilaPlayer.getCima().getValor().getTipo();
//        } else {
//            int tropaCPU = pilaCPU.getCima().getValor().getTipo();
//            int tropaPlayer = pilaPlayer.getCima().getValor().getTipo();
//        }
//        
//
//        if (tropaCPU == 1 && tropaPlayer == 1) { //mago vs mago
//            pilaCPU.pop();
//            pilaPlayer.pop();
//        } else if (tropaCPU == 1 && tropaPlayer == 2) { //mago vs arquero
//            pilaCPU.pop();
//        } else if (tropaCPU == 1 && tropaPlayer == 3) { //mago vs caballero
//            pilaPlayer.pop();
//        } else if (tropaCPU == 2 && tropaPlayer == 2) { //Arquero vs Arquero
//            pilaCPU.pop();
//            pilaPlayer.pop();
//        } else if (tropaCPU == 2 && tropaPlayer == 1) { //Arquero vs Mago
//            pilaPlayer.pop();
//        } else if (tropaCPU == 2 && tropaPlayer == 3) { //Arquero vs caballero
//            pilaCPU.pop();
//        } else if (tropaCPU == 3 && tropaPlayer == 3) { //Caballero vs Caballero
//            pilaCPU.pop();
//            pilaPlayer.pop();
//        } else if (tropaCPU == 3 && tropaPlayer == 1) { //Callero vs Mago
//            pilaCPU.pop();
//        } else if (tropaCPU == 3 && tropaPlayer == 2) { //Caballero vs Arquero
//            pilaPlayer.pop();
//        }
//
//        if (pilaPlayer.getCima() == null) {
//            pilaCPU.pop();
//        } else {
//            pilaPlayer.pop();
//        }
//    }
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
        //Choque castillo Player en camino 2
        if (frmJuego.lblTropa2CPU.getX() >= frmJuego.lblCastilloPlayer.getX() - 40) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Choco Castillo Player Camino 2");
            return 3; //Retorna 3 si hubo un choque en el castillo del Player en el camino 2
        } // Choque entre camino 2 castillo CPU
        else if (frmJuego.lblTropaPlayer2.getX() <= (frmJuego.lblCastilloCPU.getX() + 307)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Choco Castillo CPU Camino 2");
            return 4;  //Retorna 2 si hubo un choque en el castillo del CPU en el camino 2
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

    public void vidaCastillos() {

        //    PreparacionJuego prepJuego = new PreparacionJuego();
        switch (verificaDueloCastillo()) {

            case 1:
                //En caso 1 es porque hubo interaccion en el camino 1 en el castillo del Player            
//                vidaCastilloPlayer = Double.valueOf(frmJuego.lblVidasPlayer.getText());
//                vidaCastilloPlayer = vidaCastilloPlayer - 1.0;
                //vidaCastilloPlayer = vidaCastilloPlayer - prepJuego.caminoCpu1.getCima().getValor().getDanho();
                castilloPlayer.setVida(castilloPlayer.getVida() - 1);
                introUI.ActualizaVidaCastillos(1, castilloPlayer.getVida());
                break;
            case 2:
                //En caso 2 es porque hubo interaccion en el camino 1 en el castillo del CPU            
//                vidaCastilloCPU = Double.valueOf(frmJuego.lblVidasCpu.getText());
//                vidaCastilloCPU = vidaCastilloCPU - 1.5;
                //vidaCastilloCPU = vidaCastilloCPU - test;//prepJuego.caminoPlayer1.getCima().getValor().getDanho();
                castilloCPU.setVida(castilloCPU.getVida() - 1);
                introUI.ActualizaVidaCastillos(2, castilloCPU.getVida());
                break;
            case 3:
                //En caso 3 es porque hubo interaccion en el camino 2 en el castillo del Player     
//                vidaCastilloPlayer = Double.valueOf(frmJuego.lblVidasPlayer.getText());
//                vidaCastilloPlayer = vidaCastilloPlayer - 1.0;
                // vidaCastilloPlayer = vidaCastilloPlayer - prepJuego.caminoCpu2.getCima().getValor().getDanho();
//                System.out.println(caminoCpu2.getCima().getValor().getDanho());
                //castilloPlayer.setVida(castilloPlayer.getVida() - caminoCpu2.getCima().getValor().getDanho());
                castilloPlayer.setVida(castilloPlayer.getVida() - 1);
                introUI.ActualizaVidaCastillos(1, castilloPlayer.getVida());
                break;
            case 4:
                //En caso 2 es porque hubo interaccion en el camino 1 en el castillo del CPU            
//                vidaCastilloCPU = Double.valueOf(frmJuego.lblVidasCpu.getText());
//                vidaCastilloCPU = vidaCastilloCPU - 1.5;
                //vidaCastilloCPU = vidaCastilloCPU - prepJuego.caminoPlayer2.getCima().getValor().getDanho();
                castilloCPU.setVida(castilloCPU.getVida() - 1);
                introUI.ActualizaVidaCastillos(2, castilloCPU.getVida());
                break;

        }

    }

    public void interaccionCastillo() {

        //  Combate(pilaCPU, pilaPlayer);
        vidaCastillos();
//        reiniciaPosiciones();

        if (castilloPlayer.getVida() <= 0) {
            JOptionPane.showMessageDialog(frmJuego, "GANADOR CPU", "WIN", 0);

        } else if (castilloPlayer.getVida() <= 0) {
            JOptionPane.showMessageDialog(frmJuego, "GANADOR PLAYER", "WIN", 0);

        }
        verificaCastilloDestruido();

    }

    public void reiniciaPosiciones() { //Reinicia la posiciones en caso que se de un enfrentamiento en el camino 1 o 2
        if (verificaDueloCastillo() == 1 || verificaDueloCastillo() == 2) {
            frmJuego.lblTropa1CPU.setLocation(360, 460);
            frmJuego.lblTropaPlayer1.setLocation(1210, 460);

        } else if (verificaDueloCastillo() == 3 || verificaDueloCastillo() == 4) {
            frmJuego.lblTropa2CPU.setLocation(360, 570);
            frmJuego.lblTropaPlayer2.setLocation(1210, 570);

        }

    }

    public double DevolverDanio(int danio) {
        switch (danio) {
            case 1:
                    return Double.valueOf(caminoCpu1.getCima().getValor().getDanho());
            case 2:
                return Double.valueOf(caminoPlayer1.getCima().getValor().getDanho());
            case 3:
                    return Double.valueOf(caminoCpu2.getCima().getValor().getDanho());
            case 4:
                return Double.valueOf(caminoPlayer2.getCima().getValor().getDanho());
                default:
                    return 0;
        }
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
