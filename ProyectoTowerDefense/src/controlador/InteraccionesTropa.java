/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Pila;
import vista.frmJuego;
import vista.frmPreparacion;

/**
 *
 * @author Equipo4
 */
public class InteraccionesTropa {

    double vidaCastilloPlayer = 10;
    double vidaCastilloCPU = 10;
    frmJuego frmJuego;
    frmPreparacion frmPreparacion;
    InteraccionUI InteraccionUI = new InteraccionUI();

    public void moverTropas() {
        //Lo que me permite es que cada vez que se llame en el hilo toma las posiciones de las tropas y las mueve
        //  lblTropa1CPU.setLocation(lblTropa1CPU.getX() + 5, lblTropa1CPU.getY());
        // lblTropaPlayer1.setLocation(lblTropaPlayer1.getX() - 5, lblTropaPlayer1.getY());

        frmJuego.lblTropa2CPU.setLocation(frmJuego.lblTropa2CPU.getX() + 5, frmJuego.lblTropa2CPU.getY());
        //lblTropaPlayer2.setLocation(lblTropaPlayer2.getX() - 2, lblTropaPlayer2.getY());

    }

    public int verificaDueloTropas() {
        //Choque entre camino 1
        if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblTropa1CPU.getX() + 134)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Duelo camino 1");
            return 1;

        }

        // Choque entre camino 2
        if (frmJuego.lblTropaPlayer1.getX() < (frmJuego.lblTropa2CPU.getX() + 61)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Duelo camino 2");
            return 2;

        }
        return 0;

    }

    public void Combate(Pila pilaCPU, Pila pilaPlayer) {
        int tropaCPU = pilaCPU.getCima().getValor().getTipo();
        int tropaPlayer = pilaPlayer.getCima().getValor().getTipo();

        if (tropaCPU == 1 && tropaPlayer == 1) { //mago vs mago
            pilaCPU.pop();
            pilaPlayer.pop();
        } else if (tropaCPU == 1 && tropaPlayer == 2) { //mago vs arquero
            pilaCPU.pop();
        } else if (tropaCPU == 1 && tropaPlayer == 3) { //mago vs caballero
            pilaPlayer.pop();
        } else if (tropaCPU == 2 && tropaPlayer == 2) { //Arquero vs Arquero
            pilaCPU.pop();
            pilaPlayer.pop();
        } else if (tropaCPU == 2 && tropaPlayer == 1) { //Arquero vs Mago
            pilaPlayer.pop();
        } else if (tropaCPU == 2 && tropaPlayer == 3) { //Arquero vs caballero
            pilaCPU.pop();
        } else if (tropaCPU == 3 && tropaPlayer == 3) { //Caballero vs Caballero
            pilaCPU.pop();
            pilaPlayer.pop();
        } else if (tropaCPU == 3 && tropaPlayer == 1) { //Callero vs Mago
            pilaCPU.pop();
        } else if (tropaCPU == 3 && tropaPlayer == 2) { //Caballero vs Arquero
            pilaPlayer.pop();
        }

        if (pilaPlayer.getCima() == null) {
            pilaCPU.pop();
        } else {
            pilaPlayer.pop();
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
        if (vidaCastilloPlayer <= 0) {
            InteraccionUI.ActualizaVidaCastillos(1, 0);
            frmPreparacion.apagaHilo();

        } else if (vidaCastilloCPU <= 0) {
            InteraccionUI.ActualizaVidaCastillos(2, 0);
            frmPreparacion.apagaHilo();

        }

    }

    public void vidaCastillos() {

        //    PreparacionJuego prepJuego = new PreparacionJuego();
        switch (verificaDueloCastillo()) {

            case 1:
                //En caso 1 es porque hubo interaccion en el camino 1 en el castillo del Player            
                vidaCastilloPlayer = Double.valueOf(frmJuego.lblVidasPlayer.getText());
                vidaCastilloPlayer = vidaCastilloPlayer - 1.0;
                //vidaCastilloPlayer = vidaCastilloPlayer - prepJuego.caminoCpu1.getCima().getValor().getDanho();
                InteraccionUI.ActualizaVidaCastillos(1, vidaCastilloPlayer);
                break;
            case 2:
                //En caso 2 es porque hubo interaccion en el camino 1 en el castillo del CPU            
                vidaCastilloCPU = Double.valueOf(frmJuego.lblVidasCpu.getText());
                vidaCastilloCPU = vidaCastilloCPU - 1.5;
                //vidaCastilloCPU = vidaCastilloCPU - test;//prepJuego.caminoPlayer1.getCima().getValor().getDanho();
                InteraccionUI.ActualizaVidaCastillos(2, vidaCastilloCPU);
                break;
            case 3:
                //En caso 3 es porque hubo interaccion en el camino 2 en el castillo del Player     
                vidaCastilloPlayer = Double.valueOf(frmJuego.lblVidasPlayer.getText());
                vidaCastilloPlayer = vidaCastilloPlayer - 1.0;
                // vidaCastilloPlayer = vidaCastilloPlayer - prepJuego.caminoCpu2.getCima().getValor().getDanho();
                InteraccionUI.ActualizaVidaCastillos(1, vidaCastilloPlayer);
                break;
            case 4:
                //En caso 2 es porque hubo interaccion en el camino 1 en el castillo del CPU            
                vidaCastilloCPU = Double.valueOf(frmJuego.lblVidasCpu.getText());
                vidaCastilloCPU = vidaCastilloCPU - 1.5;
                //vidaCastilloCPU = vidaCastilloCPU - prepJuego.caminoPlayer2.getCima().getValor().getDanho();
                InteraccionUI.ActualizaVidaCastillos(2, vidaCastilloCPU);
                break;

        }

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

//    public void lista() {
//
//        PreparacionJuego prepJuego = new PreparacionJuego();
//        prepJuego.caminoCpu1.listar();
//        System.out.println("------------------------");
//        prepJuego.caminoPlayer1.listar();
//    }

    public void interaccionCastillo() {

        //  Combate(pilaCPU, pilaPlayer);
        vidaCastillos();
        reiniciaPosiciones();

        if (vidaCastilloPlayer <= 0) {
            JOptionPane.showMessageDialog(frmJuego, "GANADOR CPU", "WIN", 0);

        } else if (vidaCastilloCPU <= 0) {
            JOptionPane.showMessageDialog(frmJuego, "GANADOR PLAYER", "WIN", 0);

        }
        verificaCastilloDestruido();

    }
}
