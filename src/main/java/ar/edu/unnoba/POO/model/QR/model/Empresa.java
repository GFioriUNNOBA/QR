package ar.edu.unnoba.POO.model.QR.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name= "empresas")
public class Empresa implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametros
    private Long id;
    @Column(nullable = false,unique = true)
    private int razonSocial;
    @Column(nullable = false,unique = true)
    private int cuit;
    @Column(nullable = false,unique = true, name = "nombre") //preguntar si es unico
    private String username;
    @Column()//@Column(nullable = false) lo dejamos aca momentaneamente
    private boolean activo;


    @OneToMany(mappedBy = "empresa")
    private List<Gestor> gestores;
    @OneToMany(mappedBy = "empresa")
    private List<Producto> productos;


    public Empresa(Long id, int razonSocial, int cuit, String username, boolean activo, List<Gestor> gestores, List<Producto> productos) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.username = username;
        this.activo = activo;
        this.gestores = gestores;
        this.productos = productos;
    }

    public List<Gestor> getGestores() {
        return gestores;
    }

    public void setGestores(List<Gestor> gestores) {
        this.gestores = gestores;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
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
