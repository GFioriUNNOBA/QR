package ar.edu.unnoba.POO.model.QR.repository;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long>  {
    public Empresa findByUsername(String username);
    public boolean existsEmpresasByCuit(int ciut);
    public boolean existsEmpresasByRazonSocial(int rs);

    List<Empresa> findAllById(Long id);
}
