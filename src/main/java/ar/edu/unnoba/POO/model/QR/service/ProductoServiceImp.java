package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Producto;
import ar.edu.unnoba.POO.model.QR.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService, UserDetailsService {

    @Autowired
    private ProductoRepository repository;

    public ProductoServiceImp(ProductoRepository repository) {
        this.repository = repository;
    }

    public ProductoServiceImp() {
    }

    @Override
    public Producto create(Producto prod) {
        if(repository.findByUsername(prod.getUsername())==null){
            prod = repository.save(prod);
        }
        return prod;

    }

    @Override
    public List<Producto> getAll() {
        List<Producto> productos =repository.findAll();
        Collections.sort(productos, (p1, p2) -> p1.getUsername().compareToIgnoreCase(p2.getUsername()));
        return productos;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        return (UserDetails)repository.findByUsername(nombre);
    }

    @Override
    public Producto infoProducto(Long id) {
        List<Producto> productos = repository.findAll();
        for (Producto p : productos) {
            if (p.getCodigo().equals(id)) {
                return p;
            }

        }

        return null;
    }
}
