package ar.edu.unnoba.POO.model.QR;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private int razonSocial;
    private int cuit;
    private String nombre;

    private boolean activo;
    private ArrayList<Producto> prodcutos = new ArrayList<Producto>();

    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();

    public Empresa(int razonSocial, int cuit, String nombre, boolean activo, ArrayList<Producto> prodcutos, ArrayList<Gestor> gestores) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.nombre = nombre;
        this.activo = activo;
        this.prodcutos = prodcutos;
        this.gestores = gestores;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public void setGestores(ArrayList<Gestor> gestores) {
        this.gestores = gestores;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(int razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProdcutos() {
        return prodcutos;
    }

    public void setProdcutos(ArrayList<Producto> prodcutos) {
        this.prodcutos = prodcutos;
    }
}
