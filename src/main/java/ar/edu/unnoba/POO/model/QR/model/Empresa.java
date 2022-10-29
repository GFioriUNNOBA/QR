package ar.edu.unnoba.POO.model.QR.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametros
    private Long id;
    @Column(nullable = false,unique = true)
    private int razonSocial;
    @Column(nullable = false,unique = true)
    private int cuit;
    @Column(nullable = false,unique = true) //preguntar si es unico
    private String nombre;
    @Column(nullable = false)
    private boolean activo;

    @ManyToOne
    private Gestor gestor;
    @OneToMany(mappedBy = "empresa")
    private List<Producto> productos;

    public Empresa(Long id, int razonSocial, int cuit, String nombre, boolean activo, Gestor gestor, List<Producto> productos) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.nombre = nombre;
        this.activo = activo;
        this.gestor = gestor;
        this.productos = productos;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
