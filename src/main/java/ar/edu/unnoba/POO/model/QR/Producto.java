package ar.edu.unnoba.POO.model.QR;

public class Producto {
    private String nombre;
    private float importe;
    private boolean activo;
    private int codigo;
    private String descripcion;

    public Producto(String nombre, float importe, boolean activo, int codigo, String descripcion) {
        this.nombre = nombre;
        this.importe = importe;
        this.activo = activo;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
