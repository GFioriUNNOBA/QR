package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.repository.EmpresaRepository;
import ar.edu.unnoba.POO.model.QR.repository.GestorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpresaServiceImp implements IEmpresaService, UserDetailsService {
    @Autowired
    private EmpresaRepository repository;
    private GestorServiceImp gestorServiceImp;

    public EmpresaServiceImp(EmpresaRepository repository) {
        this.repository = repository;
    }

    public EmpresaServiceImp() {
    }

    @Override
    public Empresa create(Empresa empresa) {
        if (repository.findByUsername(empresa.getUsername()) == null) {
            empresa.getUsername();
            empresa = repository.save(empresa);

        }
        return empresa;
    }


    @Override
    public List<Empresa> getAll() {
        List<Empresa> empresas = repository.findAll();
        Collections.sort(empresas, (o1, o2) -> o1.getRazonSocial() - o2.getRazonSocial());
        return empresas;
    }




    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Empresa infoEmpresa(Long id) {
        List<Empresa> emp = repository.findAll();
        for (Empresa e : emp) {
            if (e.getId().equals(id)) {
                return e;
            }

        }

        return null;
    }

    @Override
    public List<Gestor> Gestores(Long id) {
        return gestorServiceImp.getAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) repository.findByUsername(username);
    }

    public Empresa Id(Long id) {
        List<Empresa> emp = repository.findAll();
        for (Empresa e : emp) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

}
