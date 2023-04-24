package controlador;

import vista.frmJuego;

/**
 * @author Grupo 4
 */
public class InteraccionesTropa {

    frmJuego frmJuego; //Creamos referencia

    public void moverTropasCamino1() {
        //Lo que me permite es que cada vez que se llame en el hilo toma las posiciones de las tropas y las mueve
        frmJuego.lblTropa1CPU.setLocation(frmJuego.lblTropa1CPU.getX() + 3, frmJuego.lblTropa1CPU.getY()); //Movemos el lblCPU un "n" número de pixeles
        frmJuego.lblTropaPlayer1.setLocation(frmJuego.lblTropaPlayer1.getX() - 3, frmJuego.lblTropaPlayer1.getY()); //Movemos el lblPLAYER un "n" número de pixeles
    }

    public int verificaDueloTropas() {
        //Choque entre camino 1
        if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblTropa1CPU.getX() + 61)) // Verifica si la posición el lblCPU está cerca del lblPLAYER
        {
            return 1;
        }

        return 0;

    }

    public int verificaDueloCastillo() { //Validacion para verificar si hubo algun enfrentamiento contra el castillo
        //Choque castillo Player en camino 1 
        if (frmJuego.lblTropa1CPU.getX() >= frmJuego.lblCastilloPlayer.getX() - 40) // Verifica si el lblCPU llegó al castillo del PLAYER
        {
            return 1; //Retorna 1 si hubo un choque en el castillo del Player en el camino 1
        } else if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblCastilloCPU.getX() + 307)) // Verifica si el lblPLAYER llegó al castillo del CPU
        {
            return 2; //Retorna 2 si hubo un choque en el castillo del CPU en el camino 1
        }

        return 0;

    }
}
