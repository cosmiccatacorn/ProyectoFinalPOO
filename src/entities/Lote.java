package entities;

public class Lote extends Propiedad{

    private String tipoDeLicencia;

    public Lote(int id, String tipo, String direccion, String estado,double precio, float areaMSq, String tipoDeLicencia) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.tipoDeLicencia = tipoDeLicencia;
    }

    public String getTipoDeLicencia() {
        return tipoDeLicencia;
    }

    public void setTipoDeLicencia(String tipoDeLicencia) {
        this.tipoDeLicencia = tipoDeLicencia;
    }
}
