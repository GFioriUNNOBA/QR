package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;


import java.util.List;

public interface IEmpresaService {

    public Empresa create(Empresa empresa);

    public List<Empresa> getAll();


    public void delete(Long id);

    public Empresa infoEmpresa(Long id);


    List<Gestor> Gestores(Long id);

    List<Empresa> findAllByEmpresaId(Long id);
}
