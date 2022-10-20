package ar.edu.unnoba.POO.model.QR.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "gestores")
public class Gestor {
    @Id //indica que el atributo id es unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametros
    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    private String password;
    @OneToMany(mappedBy = "gestor") //inica la relacion entre 2 clases, simepre que hay un ,OneToMany hay un ManyToOne, el mappedBy hace que se mapee con el atributo gestor que se encuentra en empresa
    private List<Empresa> empresa;


    public Gestor(Long id, String apellido, String nombre, String email, String password, List<Empresa> empresa) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.empresa = empresa;
    }

    public Gestor() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
