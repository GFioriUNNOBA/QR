package ar.edu.unnoba.POO.model.QR.controller;


import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.model.Producto;
import ar.edu.unnoba.POO.model.QR.service.EmpresaServiceImp;
import ar.edu.unnoba.POO.model.QR.service.ProductoServiceImp;

import com.itextpdf.text.DocumentException;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gestor/productos")
public class ProductoDelGestorController {

    @Autowired
    private ProductoServiceImp productoService;

    @Autowired
    private EmpresaServiceImp empresaServiceImp;

    @Autowired
    private QrController QR;


    @GetMapping("/index")
    public String index(Model model, Authentication authentication){
        Gestor gestor = (Gestor) authentication.getPrincipal();
        Long idEmpresa= gestor.getEmpresa().getId();
        List<Producto> prod=new ArrayList<>();
        model.addAttribute("idEmpresa", gestor.getId());
        for(Producto p : productoService.getAll()){ // deberia ir en service
            if(p.getEmpresa().getId().equals(idEmpresa)){
                prod.add(p);


            }
        }

        model.addAttribute("productosDeEsaEmpresa" , prod);

        return "/gestor/productos/index";
    }


    @GetMapping("/new")
    public String userNew(Model model, Authentication authentication){
        Gestor gestor = (Gestor) authentication.getPrincipal();
        Empresa empresa = empresaServiceImp.infoEmpresa(gestor.getId());
        Producto producto = new Producto();
        producto.setEmpresa(empresa);
        model.addAttribute("prod", producto);
        return "/gestor/productos/new";
    }

    @PostMapping
    public String create(@ModelAttribute Producto producto, Authentication authentication , Model model, @RequestParam("file")MultipartFile imagen){
        Gestor gestor = (Gestor) authentication.getPrincipal();
        Empresa empresa = empresaServiceImp.infoEmpresa(gestor.getId());
        producto.setEmpresa(empresa);
        producto.setEmpresa(gestor.getEmpresa());


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

        return "redirect:/gestor/productos/index";
    }



    @GetMapping("/delete/{idD}")
    public String delete(@PathVariable("idD") Long id,Authentication authentication){
        productoService.delete(id);
        return "redirect:/gestor/productos/index";
    }

    @GetMapping("/info/{idI}")
    public String info(@PathVariable ("idI") Long id, Model model, Authentication authentication) {
        Gestor gestor = (Gestor)  authentication.getPrincipal();
        Producto producto = productoService.infoProducto(id);
        model.addAttribute("pro",producto);

        Long empresaPertececienteAlProducto=producto.getEmpresa().getId();
        Long empresaPertececienteAlGestor= gestor.getEmpresa().getId();

        if(empresaPertececienteAlProducto != empresaPertececienteAlGestor){
            return  "redirect:/gestor/productos/index";
        } // funciona cuando quiere

        return "/gestor/productos/info";
    }

    @GetMapping ("/editar/{idE}")
    public String editarProducto(@PathVariable("idE") Long id, Model  modelo,Authentication authentication){
        modelo.addAttribute("prod", productoService.infoProducto(id));
        return "/gestor/productos/edit";
    }

    @PostMapping("/editarProducto/{idE}")
    public String actualizarProdcuto (@PathVariable("idE") Long id, @ModelAttribute("prod") Producto producto, Model modelo){
        Producto productoExistente = productoService.infoProducto(id);
        productoExistente.setUsername(producto.getUsername());
        productoExistente.setEmpresa(productoExistente.getEmpresa());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setImporte(producto.getImporte());
        //productoExistente.setIdSistemaGestion(producto.getIdSistemaGestion());
        productoExistente.setCodigo(id);
        productoExistente.setActivo(producto.isActivo());
        productoService.editarProducto(productoExistente);
        return "redirect:/gestor/productos/index";
    }

    @GetMapping("/qr/{idQr}")
    public String GenerarQr(Model model, @PathVariable("idQr") Long idQr,Authentication authentication){
        String url = "/gestor/productos/qr";
        url= "localhost:8080"+url+"/"+idQr;
        QR.getQRCode(model,url);
        model.addAttribute("idQr",idQr);

        return "/gestor/productos/QrDelProducto";
    }

   public List ListaProductosGestor(Authentication authentication){
        Gestor gestor = (Gestor)  authentication.getPrincipal();
        List listaDeProductosDelGestor= new ArrayList();
        for (Producto p : productoService.getAll()){
            if (gestor.getEmpresa().getId() == p.getEmpresa().getId()){
                listaDeProductosDelGestor.add(p);
            }

        }
        return  listaDeProductosDelGestor; //metodo que podemos borrar porque no lo usa nadie
   }


}
