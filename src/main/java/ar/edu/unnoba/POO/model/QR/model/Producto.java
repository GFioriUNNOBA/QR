package ar.edu.unnoba.POO.model.QR.model;

import javax.persistence.*;

@Entity
@Table(name= "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametro
    private int codigo;
    @Column(nullable = true,unique = true)
    private Long idSistemaGestion;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private float importe;
    @Column(nullable = false)
    private boolean activo;

    @Column(length = 100)
    private String descripcion;

   @ManyToOne
   @JoinColumn(name= "empresa_id")
    private Empresa empresa;

    public Producto() { //porque es necesario crear un contructor vacio

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public Producto(Long idSistemaGestion, String nombre, float importe, boolean activo, int codigo, String descripcion, Empresa empresa) {
        this.idSistemaGestion = idSistemaGestion;
        this.nombre = nombre;
        this.importe = importe;
        this.activo = activo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

    public Long getIdSistemaGestion() {
        return idSistemaGestion;
    }

    public void setIdSistemaGestion(Long idSistemaGestion) {
        this.idSistemaGestion = idSistemaGestion;
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
