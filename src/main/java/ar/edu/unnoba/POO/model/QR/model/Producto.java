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

    @Column(nullable = false,unique = true,name="nombre")
    private String username;
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


    public Producto(int codigo, Long idSistemaGestion, String username, float importe, boolean activo, String descripcion, Empresa empresa) {
        this.codigo = codigo;
        this.idSistemaGestion = idSistemaGestion;
        this.username = username;
        this.importe = importe;
        this.activo = activo;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdSistemaGestion() {
        return idSistemaGestion;
    }

    public void setIdSistemaGestion(Long idSistemaGestion) {
        this.idSistemaGestion = idSistemaGestion;
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
