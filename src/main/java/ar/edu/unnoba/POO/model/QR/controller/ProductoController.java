package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Producto;
import ar.edu.unnoba.POO.model.QR.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/empresa/{id}/productos")
public class ProductoController {
    private IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService prodService){
        this.productoService = prodService;
    }

    @GetMapping("/new")
    public String productNew(Model model){
        model.addAttribute("username",new Producto());
        return "admin/empresa/productos/new";
    }

    @GetMapping ("/index")
    public String index(Model model, Authentication authentication){
        List<Producto> productos = productoService.getAll();
        model.addAttribute("admin",productos);
        return "admin/empresa/productos/index";
    }

    @PostMapping
    public String create(@ModelAttribute Producto producto){
        productoService.create(producto);
        return "redirect:/admin/empresa/{id}/productos/index";
    }

    @GetMapping("/delete")
    public String delete(@PathVariable("id") Long id){
        productoService.delete(id);
        return "redirect:/admin/empresa/{id}/producto/index";
    }
}
