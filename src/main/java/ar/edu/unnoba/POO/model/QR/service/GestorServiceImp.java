package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.repository.GestorRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorServiceImp implements IGestorService, UserDetailsService {

    private GestorRespository gestorRespository;

    public GestorServiceImp(GestorRespository gestorRespository) {
        this.gestorRespository = gestorRespository;
    }

    @Override
    public Gestor create(Gestor gestor) {
        if(gestorRespository.findByUsername(gestor.getUsername())==null){
            gestor.setPassword(new BCryptPasswordEncoder().encode(gestor.getPassword()));
            gestor = gestorRespository.save(gestor);
        }
        return gestor;
    }

    @Override
    public List<Gestor> getAll() {
        List<Gestor> ges=gestorRespository.findAll();
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
