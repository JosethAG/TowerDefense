/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Equipo4
 */

public class Validacion {
    private int cantTropas;
    private int cantTropasCPU;

    public Validacion(int cantTropas, int cantTropasCPU) {
        this.cantTropas = cantTropas;
        this.cantTropasCPU = cantTropasCPU;
    }

    public int getCantTropas() {
        return cantTropas;
    }

    public void setCantTropas(int cantTropas) {
        this.cantTropas = cantTropas;
    }

    public int getCantTropasCPU() {
        return cantTropasCPU;
    }

    public void setCantTropasCPU(int cantTropasCPU) {
        this.cantTropasCPU = cantTropasCPU;
    }

    public void validacion(){
//        if(){
//
//        }
    }

    /*
    public void validacion() {
        if (cantTropas > 4) {
            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de tropas permitidas");
        } else if (cantTropas <= 4) {
            JOptionPane.showMessageDialog(null, "Tropas seleccionadas exitosamente");
        }
    }
    */
}
