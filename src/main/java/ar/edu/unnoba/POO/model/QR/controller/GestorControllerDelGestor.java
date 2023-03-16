package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.service.GestorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestor")
public class GestorControllerDelGestor {

    @Autowired
    private GestorServiceImp gestorServiceImp;


    @GetMapping("/home")
    public String gestorEnSession(Model model, Authentication authentication){
        Gestor gestor = (Gestor) authentication.getPrincipal();
        model.addAttribute("sessionGestor",gestor);
        return "/gestor/home";
    }

  /**  @GetMapping("/productos")
    public String ProductosDelGestor(Model model, Authentication authentication){
        Gestor gestor = (Gestor) authentication.getPrincipal();
        model.addAttribute("sessionGestor",gestor);

        return "/gestor/home";
    }**/
}
