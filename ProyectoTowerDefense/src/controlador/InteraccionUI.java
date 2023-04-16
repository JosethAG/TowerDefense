/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.frmJuego;
import vista.frmPreparacion;

/**
 *
 * @author Administrador
 */
public class InteraccionUI {

    frmPreparacion frmPreparacion;
    frmJuego frmJuego;

    public void ActualizarCantidadUI(String cantidadActual) {
        frmPreparacion.lblCantidadTropas.setText(cantidadActual);
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

}
