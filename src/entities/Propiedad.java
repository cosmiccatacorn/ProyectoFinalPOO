package entities;

public abstract class Propiedad {
    protected int id;
    protected String tipo;
    protected String direccion;
    protected String estado;
    protected double precio;
    protected float areaMSq;

    public Propiedad(int id, String tipo, String direccion, String estado, double precio, float areaMSq) {
        this.id = id;
        this.tipo = tipo;
        this.direccion = direccion;
        this.estado = estado;
        this.precio = precio;
        this.areaMSq = areaMSq;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getAreaMSq() {
        return areaMSq;
    }
    public void setAreaMSq(String areaMSq) {
        this.areaMSq = areaMSq;
    }
}
