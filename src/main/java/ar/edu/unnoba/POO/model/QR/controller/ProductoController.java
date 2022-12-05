package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Producto;
import ar.edu.unnoba.POO.model.QR.service.EmpresaServiceImp;
import ar.edu.unnoba.POO.model.QR.service.IProductoService;
import ar.edu.unnoba.POO.model.QR.service.ProductoServiceImp;
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
    public String productNew(Model model,@PathVariable("id") Long id){
        model.addAttribute("prod",new Producto());
        model.addAttribute("idEmpresa",id);
        return "admin/empresa/productos/new";
    }

    @GetMapping ("/index")
    public String index(Model model, Authentication authentication,@PathVariable("id") Long id){
        List<Producto> productos = productoService.getAll();
        model.addAttribute("producto",productos);
        model.addAttribute("prod",id);
        return "admin/empresa/productos/index";
    }

    @PostMapping
    public String create(@ModelAttribute Producto producto){
        productoService.create(producto);
        return "redirect:/admin/empresa/{id}/productos/index";
    }

    @GetMapping("/delete/{idD}")
    public String delete(@PathVariable("id") Long id){
        productoService.delete(id);
        return "redirect:/admin/empresa/{id}/productos/index";
    }
}
