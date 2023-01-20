package ar.edu.unnoba.POO.model.QR.repository;

import ar.edu.unnoba.POO.model.QR.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    public Producto findByUsername (String username);
    public Optional<Producto> findById (Long id);
    public Optional<Producto> findByIdSistemaGestion (Long id);


}
