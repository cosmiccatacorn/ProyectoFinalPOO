package entities;

public class Oficina extends Propiedad{

    private int piso;
    private boolean hasBano;

    public Oficina(int id, String tipo, String direccion, String estado, double precio, float areaMSq, int piso, boolean hasBano) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.piso = piso;
        this.hasBano = hasBano;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean getHasBano() {
        return hasBano;
    }

    public void setHasBano(boolean hasBano) {
        this.hasBano = hasBano;
    }
}
