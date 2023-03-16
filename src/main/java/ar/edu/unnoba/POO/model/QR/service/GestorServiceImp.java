package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.config.Roles;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.repository.EmpresaRepository;
import ar.edu.unnoba.POO.model.QR.repository.GestorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GestorServiceImp implements IGestorService, UserDetailsService {

    @Autowired
    private GestorRespository gestorRespository;
    @Autowired
    private EmpresaRepository empresaRepository;


    public GestorServiceImp(GestorRespository gestorRespository) {
        this.gestorRespository = gestorRespository;
    }

    @Override
    public Gestor create(Gestor gestor) {
        if(gestorRespository.findByUsername(gestor.getUsername())==null){
            gestor.setPassword(new BCryptPasswordEncoder().encode(gestor.getPassword()));
            gestor.setRol(Roles.ROLE_GESTOR);
            gestor = gestorRespository.save(gestor);

        }

        return gestor;
    }

    @Override
    public List<Gestor> getAll() {
        List<Gestor> ges=gestorRespository.findAll();
        Collections.sort(ges, (g1,g2) -> g1.getApellido().compareToIgnoreCase(g2.getApellido()));
        return ges;
    }

    @Override
    public void delete(Long id) {
        gestorRespository.deleteById(id);

    }

    @Override
    public Gestor info(Long id) {
        List<Gestor> ges = gestorRespository.findAll();
        for(Gestor e : ges){
            if(e.getId().equals(id)){
                return e;
            }

        }

        return null;
    }

    @Override
    public List<Gestor> findAllByGestorId(Long id) {
       return gestorRespository.findAllById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails)gestorRespository.findByUsername(username);
    }



}
