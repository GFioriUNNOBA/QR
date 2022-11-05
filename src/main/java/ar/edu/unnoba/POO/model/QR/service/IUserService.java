package ar.edu.unnoba.POO.model.QR.service;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;

import java.util.List;

public interface IUserService { //preg si el nombre esta bien y si hacemos una clase User en model,por lo que entiendo el admin puede crear una cuenta para gestores,preg si esa es la idea
    public Adminitrador create(Adminitrador user);

    public List<Adminitrador> getAll();

    public void delete(Long id);
}
