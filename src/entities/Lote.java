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

    @Override
    public String toString() {
        return "Lote{" +
                "tipoDeLicencia='" + tipoDeLicencia + '\'' +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                ", areaMSq=" + areaMSq +
                '}';
    }
}
