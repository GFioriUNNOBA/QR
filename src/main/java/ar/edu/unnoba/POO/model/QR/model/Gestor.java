package ar.edu.unnoba.POO.model.QR.model;

import ar.edu.unnoba.POO.model.QR.config.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name= "gestores")
public class Gestor implements UserDetails {
    @Id //indica que el atributo id es unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametros
    private Long id;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false,unique = true,name="email")
    private String username;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles rol;
    @ManyToOne
    @JoinColumn(name="gestor_id")//inica la relacion entre 2 clases, simepre que hay un ,OneToMany hay un ManyToOne, el mappedBy hace que se mapee con el atributo gestor que se encuentra en empresa
    private Empresa empresa;




    public Gestor() {

    }

    public Gestor(Long id, String apellido, String nombre, String username, String password, Empresa empresa) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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


    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_GESTOR"));

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
