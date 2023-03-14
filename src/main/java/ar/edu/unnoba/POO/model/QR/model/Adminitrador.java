package ar.edu.unnoba.POO.model.QR.model;

import ar.edu.unnoba.POO.model.QR.config.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name= "administradores")
public class Adminitrador implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametros
    private Long id;
    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, name = "nombre")
    private String username;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles rol;



    public Adminitrador(Long id, String apellido, String username, String email, String password) {
        this.id = id;
        this.apellido = apellido;
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    //UserDetail methods

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
    }

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
