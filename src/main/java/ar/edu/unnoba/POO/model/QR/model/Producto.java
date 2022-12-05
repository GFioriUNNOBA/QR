package ar.edu.unnoba.POO.model.QR.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name= "productos")
public class Producto implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que el id sea autoincremental con una estrategia que se pasa por parametro
    private Long codigo;
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


    public Producto(Long codigo, Long idSistemaGestion, String username, float importe, boolean activo, String descripcion, Empresa empresa) {
        this.codigo = codigo;
        this.idSistemaGestion = idSistemaGestion;
        this.username = username;
        this.importe = importe;
        this.activo = activo;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_PRODUCTO"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
