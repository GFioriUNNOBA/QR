package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import ar.edu.unnoba.POO.model.QR.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private IUserService userService;
    @Autowired
    public AdminController(IUserService userService){
        this.userService= userService;
    }
    @GetMapping
    public String index(Model model){
        List<Adminitrador> users = userService.getAll();
        model.addAttribute("admin",users);
        return "admin/index";
    }

    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("admin",new Adminitrador());
        return "admin/new";
    }


    @PostMapping
    public String create(@ModelAttribute Adminitrador user){
        userService.create(user);
        return "redirect:/admin/new";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/admin/";
    }
// metodo  public Admin (Authentication authentication)

}
