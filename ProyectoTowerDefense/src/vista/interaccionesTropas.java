
package vista;

import controlador.InteraccionesTropa;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelo
 */
class interaccionesTropas {
    
    double vidaCastilloPlayer = 10;
    double vidaCastilloCPU = 10;
    frmJuego frmJuego;

    public void verificaGanador(){
        
        if (vidaCastilloPlayer <= 0) {
            JOptionPane.showMessageDialog(frmJuego, "GANADOR CPU", "WIN", 0);

        } else if (vidaCastilloCPU <= 0) {
            JOptionPane.showMessageDialog(frmJuego, "GANADOR PLAYER", "WIN", 0);

        }
    
    }
    
    
    
}
