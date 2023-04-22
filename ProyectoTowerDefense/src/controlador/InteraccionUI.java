/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.frmJuego;


/**
 *
 * @author Administrador
 */
public class InteraccionUI {

 
    frmJuego frmJuego;
    PreparacionJuego prepJuego;

    public void ActualizarCantidadUI(String cantidadActual) {
        frmJuego.lblCantidadTropas.setText(cantidadActual);
    }

    public String ActualizarCantidadUI(int ronda) {
        return String.valueOf(ronda);
    }

    public void ActualizaVidaCastillos(int castillo, double vida) {

        if (castillo == 1) {

            frmJuego.lblVidasPlayer.setText(String.valueOf(vida));

        } else {

            frmJuego.lblVidasCpu.setText(String.valueOf(vida));
        }
    }

    public void ActualizarRonda(int ronda) {
        if (prepJuego.caminoCpu1.Vacia() && prepJuego.caminoCpu2.Vacia()
                && prepJuego.caminoPlayer1.Vacia() && prepJuego.caminoPlayer2.Vacia()) {
            frmJuego.lblNumRonda.setText(String.valueOf(ronda + 1));
        }
    }

}
