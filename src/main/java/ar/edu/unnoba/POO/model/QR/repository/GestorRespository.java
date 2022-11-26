package ar.edu.unnoba.POO.model.QR.repository;

import ar.edu.unnoba.POO.model.QR.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorRespository extends JpaRepository<Gestor,Long> {
    public Gestor findByUsername(String email); //intentemos buscar por email, si no sale buscamos por nombre
}
