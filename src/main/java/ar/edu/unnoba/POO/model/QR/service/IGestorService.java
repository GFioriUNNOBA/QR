package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;

import java.util.List;

public interface IGestorService {

    public Gestor create(Gestor gestor);

    public List<Gestor> getAll();

    public void delete(Long id);

    public Gestor info(Long id);
}
