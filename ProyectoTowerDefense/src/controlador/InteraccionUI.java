package controlador;

import vista.frmJuego;

/**
 * @author Grupo 4
 */
public class InteraccionUI {

    //Se crean referencias de los Frames necesarios para las interacciones
    frmJuego frmJuego;
    Juego prepJuego;

    public void ActualizarCantidadUI(String cantidadActual) { //Método que actualiza la cantidad de tropas disponibles y requiere el dato como parámetro
        frmJuego.lblCantidadTropas.setText(cantidadActual); //Coloca el texto según el parametro colocado
    }

    public String ActualizarCantidadUI(int ronda) { //Actualiza la ronda, este es una sobrecarga del mismo método pero con parámetro distinto
        return String.valueOf(ronda); //Devuelve el texto requerido según el parametro
    }

    public void ActualizaVidaCastillos(int castillo, double vida) { //Actualiza la vida de los castillos y recibe el castillo al que se le debe de agregar la vida y su vida actual

        if (castillo == 1) { //Valida en caso de castillo 1 (PLAYER)

            frmJuego.lblVidasPlayer.setText(String.valueOf(vida)); //Coloca la información en la pantalla de juego con el parametro solicitado

        } else { //De lo contrario será el castillo 2 (CPU)

            frmJuego.lblVidasCpu.setText(String.valueOf(vida)); //Coloca la información en la pantalla de juego con el parámetro solicitado
        }
    }

    public void ActualizarRonda(int ronda) { //Actualiza la ronda cuando las pilas están vacias
        if (prepJuego.caminoCpu1.Vacia() && prepJuego.caminoPlayer1.Vacia()) { //Verifica que las pilas estén vacias
            frmJuego.lblNumRonda.setText(String.valueOf(ronda + 1)); //Recibe el parametro de la ronda actual y le suma uno para después colocar el resultado
        }
    }
}
