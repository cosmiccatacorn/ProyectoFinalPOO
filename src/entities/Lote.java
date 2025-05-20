package entities;

public class Lote extends Propiedad{

    private String tipoDeLicencia;

    public Lote(int id, String tipo, String direccion, String estado, String precio, String areaMSq, String tipoDeLicencia) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.tipoDeLicencia = tipoDeLicencia;
    }
}
