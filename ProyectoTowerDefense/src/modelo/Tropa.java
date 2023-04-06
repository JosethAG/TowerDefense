package modelo;

public class Tropa {
    private int tipo;
    private double danho;
    private String url;

    public Tropa(int tipo,double danho,String url) {
        this.tipo = tipo;
        this.danho = danho;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
