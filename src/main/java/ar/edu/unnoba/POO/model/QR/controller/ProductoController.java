package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.model.Producto;
import ar.edu.unnoba.POO.model.QR.service.EmpresaServiceImp;
import ar.edu.unnoba.POO.model.QR.service.GestorServiceImp;
import ar.edu.unnoba.POO.model.QR.service.IProductoService;
import ar.edu.unnoba.POO.model.QR.service.ProductoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/empresa/{id}/productos")
public class ProductoController {
    @Autowired
    private ProductoServiceImp productoService;

    @Autowired
    private EmpresaServiceImp empresaServiceImp;


   @GetMapping("/index")
   public String index(@PathVariable("id") Long id,Model model){

       List<Producto> productos = productoService.getAll();
       List<Producto> prod=new ArrayList<>();

       model.addAttribute("productos", productos);
       model.addAttribute("idEmpresa", id);
       for(Producto p : productos){ // deberia ir en service
           if(p.getEmpresa().getId().equals(id)){
               prod.add(p);
               model.addAttribute("productosDeEsaEmpresa" , prod);

           }
       }

       return "admin/empresa/productos/index";
   }
   @GetMapping("/new")
   public String userNew(@PathVariable("id") Long id, Model model, Authentication authentication ){
       Empresa empresa = empresaServiceImp.infoEmpresa(id);
       Producto producto = new Producto();
       producto.setEmpresa(empresa);
       model.addAttribute("prod", producto);
       return "/admin/empresa/productos/new";
   }

    @PostMapping
    public String create(@ModelAttribute Producto producto,@PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile imagen){
        Empresa empresa = empresaServiceImp.infoEmpresa(id);
        producto.setEmpresa(empresa);

        if(!imagen.isEmpty()){
            //Path directorioImagenes = Paths.get("src//main//resources/imagenes");
            String rutaAbsoluta= "C://Productos//recursos";
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                producto.setImagen(imagen.getOriginalFilename());
            }
            catch (IOException e) {
                e.printStackTrace();

            }
        }
        productoService.create(producto);
        model.addAttribute("producto", producto);

        return "redirect:/admin/empresa/{id}/productos/index";
    }



    @GetMapping("/delete/{idD}")
    public String delete(@PathVariable("idD") Long id){
        productoService.delete(id);
        return "redirect:/admin/empresa/{id}/productos/index";
    }

    @GetMapping("/info/{idI}")
    public String info(@PathVariable ("idI") Long id, Model model) {
        Producto producto = productoService.infoProducto(id);
        model.addAttribute("pro",producto);

        return "/admin/empresa/productos/info";
    }
/**
    @GetMapping ("/editar/{idE}")
    public String editarProducto(@PathVariable("idE") Long id, Model  modelo){
        modelo.addAttribute("prod", productoService.infoProducto(id));
        return "/admin/empresa/productos/edit";
    }

    @PostMapping("/editarProducto/{idE}")
    public String actualizarProdcuto (@PathVariable("idE") Long id, @ModelAttribute("prod") Producto producto, Model modelo){
        Producto productoExistente = productoService.infoProducto(id);
        productoExistente.setUsername(producto.getUsername());
        productoExistente.setEmpresa(productoExistente.getEmpresa());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setImporte(producto.getImporte());
        productoExistente.setIdSistemaGestion(producto.getIdSistemaGestion());
        productoExistente.setCodigo(id);
        productoExistente.setActivo(producto.isActivo());
        productoService.editarProducto(productoExistente);
        return "redirect:/admin/empresa/{id}/productos/index";
    }
**/


}
