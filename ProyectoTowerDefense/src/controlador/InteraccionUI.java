/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.frmPreparacion;

/**
 *
 * @author Administrador
 */
public class InteraccionUI {
    frmPreparacion frmPreparacion;
    
    public void ActualizarCantidadUI(String cantidadActual){
        frmPreparacion.lblCantidadTropas.setText(cantidadActual);
    }
    
    public String ActualizarCantidadUI(int ronda){
        return String.valueOf(ronda);
    }
    

    
}
