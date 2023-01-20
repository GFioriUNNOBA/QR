package ar.edu.unnoba.POO.model.QR.service;


import ar.edu.unnoba.POO.model.QR.model.Producto;

import java.util.List;

public interface IProductoService {

    public Producto create(Producto user);

    public List<Producto> getAll();


    public void delete(Long id);

    Producto infoProducto(Long id);

    Producto editarProducto(Producto producto);
}
