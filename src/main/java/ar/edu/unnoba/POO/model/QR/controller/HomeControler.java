package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.service.GestorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/home")
public class HomeControler {

    private final GestorServiceImp gestorServiceImp;

    @Autowired
    public HomeControler(GestorServiceImp gestorServiceImp) {
        this.gestorServiceImp = gestorServiceImp;
    }

    @GetMapping({"/","/home"})
    public String goHome(Model model){
        return "home";
    }

    @GetMapping("/register")
    public String goRegister(Model model){
        model.addAttribute("gestor",new Gestor());
        return "/register";
    }


    @PostMapping("/register")
    public String registerGestor(@ModelAttribute Gestor gestor){
        gestorServiceImp.create(gestor);
        return "home";
    }

}
