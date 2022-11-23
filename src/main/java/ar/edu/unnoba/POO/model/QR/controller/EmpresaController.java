package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.service.IEmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.kerberos.KerberosKey;
import java.util.List;

@Controller
@RequestMapping("/admin/empresa")
public class EmpresaController {
    private IEmpresaService empresaService;

    @Autowired
    public EmpresaController(IEmpresaService empresaService) {
        this.empresaService = empresaService;
    }


    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("emp",new Empresa());
        return "admin/empresa/new";
    }

    @GetMapping("/index")
    public String index(Model model, Authentication authentication){
       // Empresa sessionempresa = (Empresa) authentication.getPrincipal();
        List<Empresa> empresa = empresaService.getAll();
        model.addAttribute("empresa",empresa);
    //    model.addAttribute("sessionempresa",sessionempresa);
        return "admin/empresa/index";
    }

    @PostMapping
    public String create(@ModelAttribute Empresa user){
        empresaService.create(user);
        return "redirect:/admin/empresa/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Authentication authentication, RedirectAttributes redirectAttributes){
        return "redirect:/empresa";
    }

    @GetMapping("/admin/empresa/{id}")
    public void info(@PathVariable("id") Long id){

    }

}
