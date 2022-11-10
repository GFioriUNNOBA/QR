package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import ar.edu.unnoba.POO.model.QR.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class AdminServiceImp implements IUserService, UserDetailsService {
    private final AdminRepository repository;

    public AdminServiceImp(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public Adminitrador create(Adminitrador user) {
        if(repository.findByNombre(user.getUsername())==null){
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user = repository.save(user);
        }
        return user;

    }

    @Override
    public List<Adminitrador> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
