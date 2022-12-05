package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import ar.edu.unnoba.POO.model.QR.model.Empresa;
import ar.edu.unnoba.POO.model.QR.model.Gestor;
import ar.edu.unnoba.POO.model.QR.service.EmpresaServiceImp;
import ar.edu.unnoba.POO.model.QR.service.GestorServiceImp;
import ar.edu.unnoba.POO.model.QR.service.IEmpresaService;
import ar.edu.unnoba.POO.model.QR.service.IGestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/empresa/{id}/gestores")
public class GestorController {


    @Autowired
    private EmpresaServiceImp empresaServiceImp;
    @Autowired
    private GestorServiceImp gestorServiceImp;



    @GetMapping("/index")
    public String index(@PathVariable("id") Long id,Model model){

        List<Gestor> gestores = gestorServiceImp.getAll();
        List<Gestor> ges=new ArrayList<>();

        model.addAttribute("gestores", gestores);
        model.addAttribute("idEmpresa", id);
        for(Gestor g : gestores){ // deberia ir en service
            if(g.getEmpresa().getId().equals(id)){
                ges.add(g);
                model.addAttribute("gestoresDeEsaEmpresa" , ges);

            }
        }

        return "admin/empresa/gestores/index";
    }
    @GetMapping("/new")
    public String userNew(@PathVariable("id") Long id, Model model, Authentication authentication ){
        Empresa empresa = empresaServiceImp.infoEmpresa(id);
        Gestor gestor = new Gestor();
        gestor.setEmpresa(empresa);
        model.addAttribute("gestor", gestor);
        return "/admin/empresa/gestores/new";
    }

    @PostMapping
    public String create(@ModelAttribute Gestor gestor,@PathVariable("id") Long id, Model model, Authentication authentication){
        Empresa empresa = empresaServiceImp.infoEmpresa(id);
        gestor.setEmpresa(empresa);
        gestorServiceImp.create(gestor);

        return "redirect:/admin/empresa/{id}/gestores/index";
    }


  /**  @GetMapping("/new")
    public String userNew(Model model,@PathVariable("id") Long id){
        model.addAttribute("gestor",new Gestor());
        model.addAttribute("idEmpresa", id);

        return "/admin/empresa/gestores/new";
    }

    @GetMapping("/index")
    public String index(@PathVariable("id") Long id,Model model){
        Empresa empresa = empresaService.infoEmpresa(id);
        List<Gestor> gestores = gestorService.getAll();
        empresa.setGestores(gestores);
        model.addAttribute("idEmpresa",empresa);

        return "/admin/empresa/gestores/index";
    }

    @PostMapping
    public String create(@ModelAttribute Gestor gestor,@PathVariable("id") Long id){
        Gestor g= gestorService.create(gestor);

        return "redirect:/admin/empresa/{id}/gestores/index";
    }**/

    @GetMapping("/delete")
    public String delete(@PathVariable("id") Long id){
        gestorServiceImp.delete(id);
        return "redirect:/index";
    }


    @GetMapping("/info")
    public String info(@PathVariable ("id") Long id, Model model) {
        Gestor gestor = gestorServiceImp.info(id);
        model.addAttribute("ges",gestor);

        return "/admin/empresa/gestores/info";
    }


}
