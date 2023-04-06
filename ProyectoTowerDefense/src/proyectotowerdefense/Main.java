/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotowerdefense;

import controlador.InteraccionesTropa;

/**
 *
 * @author Equipo4
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila caminoCpu1 = new Pila();
        Pila caminoPlayer1 = new Pila();
        Pila caminoCpu2 = new Pila();
        Pila caminoPlayer2 = new Pila();
        Castillo castilloCPU = new Castillo(1, 10, 1);
        Castillo castilloPlayer = new Castillo(2, 10, 2);
        InteraccionesTropa interaccion = new InteraccionesTropa();
        int ronda = 1;
        boolean repetir = true;
        //Ciclo Principal
        while (repetir) {
            //Menu
            //Ciclo juego
            while (castilloCPU.getVida() > 0 || castilloPlayer.getVida() > 0) {
                //preparacion
                //interaccion.Seleccion(caminoPlayer1, caminoPlayer2, ronda);

                //inicio
                //interacciones
                while (castilloCPU.getVida() > 0 || castilloPlayer.getVida() > 0 && (caminoCpu1.getCima() != null
                        && caminoCpu2.getCima() != null && caminoPlayer1.getCima() != null
                        && caminoPlayer1.getCima() != null)) {

                    //Validacion para interaccion entre Camino1 CPU y Player
                    if (caminoCpu1.getCima().getValor().getTipo() == 1) {
                        interaccion.CombateMago(caminoCpu1, caminoPlayer1);
                    }
                    if (caminoCpu1.getCima().getValor().getTipo() == 2) {
                        interaccion.CombateArquero(caminoCpu1, caminoPlayer1);
                    }
                    if (caminoCpu1.getCima().getValor().getTipo() == 3) {
                        interaccion.CombateCaballero(caminoCpu1, caminoPlayer1);
                    }
                    //Validacion para interaccion entre Camino2 CPU y Player
                    if (caminoCpu2.getCima().getValor().getTipo() == 1) {
                        interaccion.CombateMago(caminoCpu2, caminoPlayer2);
                    }
                    if (caminoCpu2.getCima().getValor().getTipo() == 2) {
                        interaccion.CombateArquero(caminoCpu2, caminoPlayer2);
                    }
                    if (caminoCpu2.getCima().getValor().getTipo() == 3) {
                        interaccion.CombateCaballero(caminoCpu2, caminoPlayer2);
                    }

                }
                ronda++;
            }
        }

    }

}
