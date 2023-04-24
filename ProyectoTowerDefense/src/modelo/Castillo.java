package modelo;

/**
 * @author Grupo 4
 */

public class Castillo {
        //Propiedades del castillo
        private int id;
        private double vida;
        private int tipo;

    public Castillo(int id, double vida, int tipo) {
        this.id = id;
        this.vida = vida;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


}
