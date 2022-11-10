package ar.edu.unnoba.POO.model.QR.repository;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


public interface AdminRepository extends JpaRepository<Adminitrador,Long> {
    public Adminitrador findByNombre(String nombre);
    //JPAQL -> "Select u from User u where u.userName=:userName"
    //SQL -> "Select * from usuarios where userName = ?"
}
