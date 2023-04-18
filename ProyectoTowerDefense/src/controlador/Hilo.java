/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.frmJuego;

/**
 *
 * @author Angelo
 */
public class Hilo extends Thread {

    frmJuego frmJuego; //Se crea la referncia global 
    InteraccionesTropa interaccionesT = new InteraccionesTropa();
    boolean ejecutar = true;

    public Hilo(frmJuego frmJuego) { //Metodo constructor que recibe la referencia que se le envia por parametro en el frmJuego
        this.frmJuego = frmJuego;
    }
    public void detieneHilo(){
     ejecutar = false;
    }

    public void run()//Metodo que nos va a permitir que el hilo inicie cuando le demos la instruccion    
    {
        try //Try catch para capturar el error en caso de que se caiga 
        {

            while (ejecutar) //Se crea un ciclo infinito porque el proceso siempre va a estar corriendo
            {

                interaccionesT.moverTropas();
//
//                if (interaccionesT.verificaDueloTropas() == 1 ||  interaccionesT.verificaDueloTropas() == 2)
//                {
//                  sleep(100);
//                  interaccionesT.combate();
//                }
                if (interaccionesT.verificaDueloCastillo() == 1 || interaccionesT.verificaDueloCastillo() == 2 || 
                        interaccionesT.verificaDueloCastillo() == 3 || interaccionesT.verificaDueloCastillo() == 4) {

                    interaccionesT.interaccionCastillo();                 
            }

                sleep(10); //El tiempo en que se va a dormir el hilo en milisegundos


            }

        } catch (Exception e) { //Captura y muestra el error
            System.out.println("Error en la ejecucion del proceso: " + e);
        }

    }
    

}
