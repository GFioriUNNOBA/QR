package ar.edu.unnoba.POO.model.QR.repository;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import ar.edu.unnoba.POO.model.QR.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long>  {
    public Empresa findByUsername(String username);
}
