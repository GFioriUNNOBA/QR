package ar.edu.unnoba.POO.model.QR.model;

import javax.persistence.*;

@Entity
@Table(name= "administradores")
public class Adminitrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametros
    private Long id;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    public Adminitrador(Long id, String apellido, String nombre, String email, String password) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Adminitrador() {
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
