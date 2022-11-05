package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AdminServiceImp implements IUserService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public Adminitrador create(Adminitrador user) {
        return null;
    }

    @Override
    public List<Adminitrador> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
