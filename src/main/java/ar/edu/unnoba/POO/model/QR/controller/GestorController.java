package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.service.IEmpresaService;
import ar.edu.unnoba.POO.model.QR.service.IGestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gestor")
public class GestorController {

    private IGestorService gestorService;
    @Autowired
    public GestorController(IGestorService gestorService) {
        this.gestorService = gestorService;
    }


    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("gestor",new Gestor());
        return "gestor/new";
    }

    @GetMapping("/index")
    public String index(Model model, Authentication authentication){
        List<Gestor> gestor = gestorService.getAll();
        model.addAttribute("g",gestor);
        return "gestor/index";
    }

    @PostMapping
    public String create(@ModelAttribute Gestor gestor){
        gestorService.create(gestor);
        return "redirect:/gestor/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        gestorService.delete(id);
        return "redirect:/gestor/index";
    }


    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model) {
        Gestor gestor = gestorService.info(id);
        model.addAttribute("ges",gestor);

        return "/gestor/info";
    }
}
