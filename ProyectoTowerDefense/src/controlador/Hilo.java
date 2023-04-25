package controlador;

import vista.frmJuego;

/**
 * @author Grupo 4
 */
public class Hilo extends Thread {

    frmJuego frmJuego; //Se crea la referncia global 
    InteraccionesTropa interaccionesT = new InteraccionesTropa(); //Referencia de InteraccionesTropa
   
    public Hilo(frmJuego frmJuego) { //Metodo constructor que recibe la referencia que se le envia por parametro en el frmJuego
        this.frmJuego = frmJuego; //Seteamos la informacion del frame principal
    }

    public void run()//Metodo que nos va a permitir que el hilo inicie cuando le demos la instruccion    
    {
        try //Try catch para capturar el error en caso de que se caiga 
        {

            while (!isInterrupted()) //Se crea un ciclo infinito porque el proceso siempre va a estar corriendo
            
            {

                interaccionesT.moverTropasCamino1(); //Realizamos el movimientos de las tropas

                if (interaccionesT.verificaDueloTropas() == 1 || interaccionesT.verificaDueloTropas() == 2) { //Verifica donde se da la interaccion con la tropa
                    sleep(10); //Detiene brevemente la ejecución
                    frmJuego.interTropas(); //Ejecuta metodo para validar las interacciones

                }
                if (interaccionesT.verificaDueloCastillo() == 1 || interaccionesT.verificaDueloCastillo() == 2) {  ///Verifica donde se da la interaccion con el castillo

                    frmJuego.interCastillo();// Ejecuta la validaciones para los casos de los castillos
                    sleep(10); //Detiene momentaneamente el hilo
                }

                sleep(10); //El tiempo en que se va a dormir el hilo en milisegundos

            }

        } catch (Exception e) { //Captura y muestra el error
            System.out.println("Error en la ejecucion del proceso: " + e);
        }

    }

}
