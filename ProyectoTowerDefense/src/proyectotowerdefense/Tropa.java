package proyectotowerdefense;

public class Tropa {
    private int tipo;
    private double danho;

    public Tropa(int tipo) {
        this.tipo = tipo;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getDanho() {
        return danho;
    }

    public void setDanho(double danho) {
        this.danho = danho;
    }
}
