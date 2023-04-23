/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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

    public void moverTropasCamino1() {
        //Lo que me permite es que cada vez que se llame en el hilo toma las posiciones de las tropas y las mueve

        frmJuego.lblTropa1CPU.setLocation(frmJuego.lblTropa1CPU.getX() + 3, frmJuego.lblTropa1CPU.getY());
        frmJuego.lblTropaPlayer1.setLocation(frmJuego.lblTropaPlayer1.getX() - 3, frmJuego.lblTropaPlayer1.getY());

    }
    

    public int verificaDueloTropas() {
        //Choque entre camino 1
        if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblTropa1CPU.getX() + 61)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            //     System.out.println("Duelo camino 1");
            return 1;
        }
        
        return 0;

    }

    public int verificaDueloCastillo() { //Validacion para verificar si hubo algun enfrentamiento contra el castillo
        //Choque castillo Player en camino 1 
        if (frmJuego.lblTropa1CPU.getX() >= frmJuego.lblCastilloPlayer.getX() - 40) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            //System.out.println("Choco Castillo Player Camino 1");
            return 1; //Retorna 1 si hubo un choque en el castillo del Player en el camino 1
        } // Choque entre camino 1 castillo CPU
        else if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblCastilloCPU.getX() + 307)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            //   System.out.println("Choco Castillo CPU Camino 1");
            return 2; //Retorna 2 si hubo un choque en el castillo del CPU en el camino 1
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

}
