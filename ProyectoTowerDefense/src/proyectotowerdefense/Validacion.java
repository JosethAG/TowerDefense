/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotowerdefense;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Validacion {
    private int cantTropas;

    public Validacion(int cantTropas) {
        this.cantTropas = cantTropas;
    }
    public Validacion() {
        this.cantTropas = 0;
    }

    public int getCantTropas() {
        return cantTropas;
    }

    public void setCantTropas(int cantTropas) {
        this.cantTropas = cantTropas;
    }
    public void validacion(){
    if (cantTropas > 4){
         JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de tropas permitidas");
}else if(cantTropas <= 4){
        JOptionPane.showMessageDialog(null, "Tropas seleccionadas exitosamente");
    }
}
}
