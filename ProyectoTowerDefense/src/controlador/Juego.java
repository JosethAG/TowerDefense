/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelo.Castillo;
import modelo.Pila;
import modelo.Tropa;
import vista.frmJuego;

/**
 * @author Grupo 4
 */
public class Juego {

    //Variables de apollo para cantidades de tropas
    private int cantidadActual;
    private int cantidadMax;
    //Iniciamos referencias
    Pila caminoCpu1 = new Pila();
    Pila caminoPlayer1 = new Pila();
    Castillo castilloCPU = new Castillo(1, 10, 1);
    Castillo castilloPlayer = new Castillo(2, 10, 2);
    InteraccionUI introUI = new InteraccionUI();
    frmJuego frmJuego;
    //Creamos objetos de Icon para las tropas
    Icon iconoPlayer1;
    Icon iconoCPU1;

    public void AgregarTropaUI(int cantTropaUI, int ronda, String camino,
            int tropa, double danho, String url) { //Metodo para insetar Tropas para el PLAYER
        cantidadActual = cantTropaUI; //Obtenemos la cantidad de tropas desde el frame como parámetro
        cantidadMax = ronda + 4; //Calculámos la cantidad de tropas por usar cada ronda

        if (cantidadActual > cantidadMax) { //Verificamos si se pueden agregar tropas o llegamos al tope
            return; //Cancelamos cualquier metodo de agregar
        }

        if (camino.equals("1")) { //Validación en caso de existir otro camino
            caminoPlayer1.push(new Tropa(tropa, danho, url)); //Se realiza el push de la tropa según parámetros
        }
        cantidadActual--; //Disminuimos la cantidad de tropas utilizables
        introUI.ActualizarCantidadUI(String.valueOf(cantidadActual)); //Actualizamos en el frame la cantidad de tropas utilizables
        introUI.ActualizarCantidadUI(ronda); //Actualizamos ronda
    }

    public void RandomCPU(int ronda) {//Genera las pilas del CPU
        cantidadMax = ronda + 3; //Cantidad max de la tropa
        Random azar = new Random(); //Instanciamos Random
        int numPush = 0; //cantidad de push posibles
        int cantCamino1 = 0; //Cantidad de tropas colocadas camino 1

        while (cantidadMax > numPush) { // Ciclo para validar si tenemos push disponibles
            int tropa = (azar.nextInt(3) + 1); // generamos el numero de tropa

            switch (tropa) {
                case 1:
                    caminoCpu1.push(new Tropa(tropa, 1.5,
                            "/img/Mago-rojo-x54.png")); //push a la pila
                    cantCamino1++; // incrementamos las tropas agregadas
                    numPush++; //Incrementamos la cantidad de push hechos
                    break;
                case 2:
                    caminoCpu1.push(new Tropa(tropa, 1,
                            "/img/Arquera-Roja-x59.png"));
                    cantCamino1++; // incrementamos las tropas agregadas
                    numPush++; //Incrementamos la cantidad de push hechos
                    break;
                case 3:
                    caminoCpu1.push(new Tropa(tropa, 2,
                            "/img/caballero-Rojo-x59.png"));
                    cantCamino1++; // incrementamos las tropas agregadas
                    numPush++; //Incrementamos la cantidad de push hechos
                    break;

            }
        }
    }

    public void ActualizarIconoCam() { //Actualiza los Iconos de los caminos

        if (caminoPlayer1.Vacia() != true) { //Verificamos pilas
            iconoPlayer1 = new ImageIcon(getClass().getResource(
                    caminoPlayer1.getCima().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa correspondiente
            frmJuego.lblTropaPlayer1.setIcon(iconoPlayer1); // Colocamos el icono en el lbl
        }
        if (caminoCpu1.Vacia() != true) { //Verificamos pilas
            iconoCPU1 = new ImageIcon(getClass().getResource(
                    caminoCpu1.getCima().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa correspondiente
            frmJuego.lblTropa1CPU.setIcon(iconoCPU1); // Colocamos el icono en el lbl
        }

        if (caminoPlayer1.Vacia()) { //Verifica que la pila esté vacia
            frmJuego.lblTropaPlayer1.setLocation(10000, 515); //Colocamos el lbl fuera de rango para evitar interacciones 
            frmJuego.lblTropaPlayer1.setVisible(false); //Colocalos el lbl como invisible
        }

        if (caminoCpu1.Vacia()) { //Verifica que la pila esté vacia
            frmJuego.lblTropa1CPU.setLocation(-10000, 515); //Colocamos el lbl fuera de rango para evitar interacciones 
            frmJuego.lblTropa1CPU.setVisible(false); //Colocalos el lbl como invisible

        }
    }

    public void ActualizarIconoIncial() { //Actualiza los Iconos de los caminos al inicio

        iconoPlayer1 = new ImageIcon(getClass().getResource(
                caminoPlayer1.getCima().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa correspondiente
        frmJuego.lblTropaPlayer1.setIcon(iconoPlayer1); //Colocamos el icon en el lbl
        frmJuego.lblTropaPlayer1.setVisible(true); //Colocalos el lbl como visible

        iconoCPU1 = new ImageIcon(getClass().getResource(
                caminoCpu1.getCima().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa correspondiente
        frmJuego.lblTropa1CPU.setIcon(iconoCPU1); //Colocamos el icon en el lbl
        frmJuego.lblTropa1CPU.setVisible(true); //Colocalos el lbl como visible

        frmJuego.lblTropa1CPU.setLocation(360, 515); //Colocamos en la ubicaciones predeterminadas CPU
        frmJuego.lblTropaPlayer1.setLocation(1210, 515); //Colocamos en la ubicaciones predeterminadas PLAYER

    }

    public void MostrarTropasCPU() { //Musetra las primeras 3 tropas enemigas
        Icon iconoCPU; //Creamos objeto de Icon

        iconoCPU = new ImageIcon(getClass().getResource(
                caminoCpu1.getCima().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa 1
        frmJuego.lblCPU1.setIcon(iconoCPU); //Colocamos el icono en el lbl

        iconoCPU = new ImageIcon(getClass().getResource(
                caminoCpu1.getCima().getSiguiente().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa 2
        frmJuego.lblCPU2.setIcon(iconoCPU); //Colocamos el icono en el lbl

        iconoCPU = new ImageIcon(getClass().getResource(
                caminoCpu1.getCima().getSiguiente().getSiguiente().getValor().getUrl())); //Creamos el icono con la url de la img de la tropa 3
        frmJuego.lblCPU3.setIcon(iconoCPU); //Colocamos el icono en el lbl
    }

 
    public void lista() { //Lista de pila CPU
        System.out.println("---------------------------\nTropas Enemigas de la Ronda\n---------------------------");
        caminoCpu1.listar();

    }

    public int verificaDueloTropas() { //Se valida en cuál camino es el duelo
        //Choque entre camino 1
        if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblTropa1CPU.getX() + 61)) // Verifica el duelo entro tropa PLAYER y CPU
        {

            return 1;

        }
        return 0;

    }

    public void Combate(int camino) { //Cambate de tropas parametro de camino en caso de existir más
        //Variables auxiliares para reconocer qué tipo de tropa es
        int tropaCPU = 0;
        int tropaPlayer = 0;

        if (camino == 1) { //Validamos camino 

            if (caminoCpu1.Vacia() != true && caminoPlayer1.Vacia() != true) { //Se valida que no estén vacias
                //Se guarda el dato del tipo de tropa para CPU y PLAYER
                tropaCPU = caminoCpu1.getCima().getValor().getTipo();
                tropaPlayer = caminoPlayer1.getCima().getValor().getTipo();

                if (tropaCPU == 1 && tropaPlayer == 1) { //mago vs mago
                    caminoCpu1.pop();
                    caminoPlayer1.pop();
                } else if (tropaCPU == 1 && tropaPlayer == 2) { //mago vs arquero
                    caminoCpu1.pop();
                } else if (tropaCPU == 1 && tropaPlayer == 3) { //mago vs caballero
                    caminoPlayer1.pop();
                } else if (tropaCPU == 2 && tropaPlayer == 2) { //Arquero vs Arquero
                    caminoCpu1.pop();
                    caminoPlayer1.pop();
                } else if (tropaCPU == 2 && tropaPlayer == 1) { //Arquero vs Mago
                    caminoPlayer1.pop();
                } else if (tropaCPU == 2 && tropaPlayer == 3) { //Arquero vs caballero
                    caminoCpu1.pop();
                } else if (tropaCPU == 3 && tropaPlayer == 3) { //Caballero vs Caballero
                    caminoCpu1.pop();
                    caminoPlayer1.pop();
                } else if (tropaCPU == 3 && tropaPlayer == 1) { //Callero vs Mago
                    caminoCpu1.pop();
                } else //Caballero vs Arquero
                {
                    caminoPlayer1.pop();
                }
            }

        }
    }

    public int verificaDueloCastillo() { //Validacion para verificar si hubo algun enfrentamiento contra el castillo
        //Choque castillo Player en camino 1 
        if (frmJuego.lblTropa1CPU.getX() >= frmJuego.lblCastilloPlayer.getX() - 40) // Verifica el duelo contra el castillo del PLayer
        {

            return 1; //Retorna 1 si hubo un choque en el castillo del Player en el camino 1
        } // Choque entre camino 1 castillo CPU
        else if (frmJuego.lblTropaPlayer1.getX() <= (frmJuego.lblCastilloCPU.getX() + 307)) // Verifica el duelo contra el castillo del PLayer
        {

            return 2; //Retorna 2 si hubo un choque en el castillo del CPU en el camino 1
        }

        return 0;

    }

    public void ReiniciaPosicionesCam() { //Relocalización de tropas
        if (caminoCpu1.Vacia() != true && caminoPlayer1.Vacia() != true) { //Si no están vacias colocamos correctamente
            frmJuego.lblTropa1CPU.setLocation(360, 515); //Ubicación predeterminada
            frmJuego.lblTropaPlayer1.setLocation(1210, 515); //Ubicación predeterminada

        } else if (caminoCpu1.Vacia() && caminoPlayer1.Vacia()) { //Si están vacias colocamos fuera del mapa
            frmJuego.lblTropa1CPU.setLocation(-100000, 515); //Ubicación fuera de mapa
            frmJuego.lblTropaPlayer1.setLocation(100000, 515); //Ubicación fuera de mapa

        } else if (caminoPlayer1.Vacia()) { //Si player está vacia se coloca fuera de mapa evitando interacciones
            frmJuego.lblTropaPlayer1.setLocation(100000, 515); //Ubicación fuera de mapa

        } else { //Si CPU está vacia se coloca fuera de mapa evitando interacciones
            frmJuego.lblTropa1CPU.setLocation(-3000, 515); //Ubicación fuera de mapa
        }

        if (verificaDueloCastillo() == 1 || verificaDueloCastillo() == 2) { //Se obtiene donde se realizó la interacción
            if (!caminoCpu1.Vacia() && !caminoPlayer1.Vacia()) { //Si no están vacias colocamos correctamente
                frmJuego.lblTropa1CPU.setLocation(360, 515); //Ubicación predeterminada
                frmJuego.lblTropaPlayer1.setLocation(1210, 515); //Ubicación predeterminada

            } else if (caminoCpu1.Vacia() && caminoPlayer1.Vacia()) { //Si están vacias colocamos fuera del mapa
                frmJuego.lblTropa1CPU.setLocation(-100000, 515); //Ubicación fuera de mapa
                frmJuego.lblTropaPlayer1.setLocation(100000, 515); //Ubicación fuera de mapa

            } else if (caminoPlayer1.Vacia()) { //Si player está vacia se coloca fuera de mapa evitando interacciones
                frmJuego.lblTropa1CPU.setLocation(360, 515); //Ubicación predeterminada
                frmJuego.lblTropaPlayer1.setLocation(100000, 515); //Ubicación fuera de mapa

            } else { //Si CPU está vacia se coloca fuera de mapa evitando interacciones
                frmJuego.lblTropa1CPU.setLocation(-100000, 515); //Ubicación fuera de mapa
                frmJuego.lblTropaPlayer1.setLocation(1210, 515); //Ubicación predeterminada
            }

        }
    }

    public double DevolverDanio(int castillo) { //Enviar daño de tropa correspondiente (parametro de tropa CPU o PLAYER)
        switch (castillo) {
            case 1:
                return Double.valueOf(caminoCpu1.getCima().getValor().getDanho()); //Devuelve el daño de la tropa CPU
            case 2:
                return Double.valueOf(caminoPlayer1.getCima().getValor().getDanho()); //Devuelve el daño de la tropa PLAYER
            default:
                return 0;
        }
    }

    public void EliminarTropaCastillo(int camino) { //Elimina la tropa que choca con el castillo
        switch (camino) {
            case 1:
                caminoCpu1.pop(); //Elimina si CPU llegó
                break;
            case 2:
                caminoPlayer1.pop(); //Elimina si PLAYER llegó
                break;
        }
    }

    public boolean CambioRonda() { //Cambia la ronda
        if (caminoPlayer1.Vacia() && caminoCpu1.Vacia()) { //Verifica que las pilas estén vacias para cambiar de ronda
            int numR = Integer.parseInt(frmJuego.lblNumRonda.getText()) + 1; //Obtenemos la ronda + 1 para conseguir el valor de la siguiente ronda
            frmJuego.lblNumRonda.setText(String.valueOf(numR)); //Colocamos en el frame principal la nueva ronda
            frmJuego.lblCantidadTropas.setText(String.valueOf(numR + 4)); //Colocamos en el frame principal las tropas utilizables 
            frmJuego.lblTropa1CPU.setLocation(360, 515); //Ubicación predeterminada
            frmJuego.lblTropaPlayer1.setLocation(1210, 515); //Ubicación predeterminada
            return true;
        }
        return false;
    }

    public Castillo getCastilloCPU() {
        return castilloCPU;
    }

    public void setCastilloCPU(Castillo castilloCPU) {
        this.castilloCPU = castilloCPU;
    }

    public Castillo getCastilloPlayer() {
        return castilloPlayer;
    }

    public void setCastilloPlayer(Castillo castilloPlayer) {
        this.castilloPlayer = castilloPlayer;
    }

}
