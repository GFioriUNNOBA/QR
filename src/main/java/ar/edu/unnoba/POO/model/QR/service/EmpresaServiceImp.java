package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaServiceImp implements IEmpresaService, UserDetailsService {
    @Autowired
    private EmpresaRepository repository;

    public EmpresaServiceImp(EmpresaRepository repository) {
        this.repository = repository;
    }

    public EmpresaServiceImp() {
    }

    @Override
    public Empresa create(Empresa empresa) {
        if(repository.findByUsername(empresa.getUsername())== null){
            empresa.getUsername();
            empresa = repository.save(empresa);

        }
        return empresa;
    }

    @Override
    public List<Empresa> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void info(Empresa empresa) {
       repository.findById(empresa.getId());

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails)repository.findByUsername(username);
    }
}
