package ar.edu.unnoba.POO.model.QR.controller;


import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.service.IEmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Empresa> empresa = empresaService.getAll();
        model.addAttribute("empresa",empresa);
        return "admin/empresa/index";
    }

    @PostMapping
    public String create(@ModelAttribute Empresa user){
        empresaService.create(user);
        return "redirect:/admin/empresa/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Empresa empresa=empresaService.infoEmpresa(id);
        if(empresa.getProductos().size() == 0){
            empresaService.delete(id);
            return "redirect:/admin/empresa/index";
        }
        return "redirect:/admin/empresa/index";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model) {
        Empresa empresa = empresaService.infoEmpresa(id);
        model.addAttribute("empre",empresa);

        return "/admin/empresa/info";
    }
    @GetMapping("/{id}")
    public String id(@PathVariable Long id){
        return "redirect:/admin/empresa/{id}/gestores/index";
    }
    @GetMapping("/{id}/prodcutos")
    public String productos(@PathVariable Long id){
        return "redirect:/admin/empresa/{id}/productos/index";
    }










}
