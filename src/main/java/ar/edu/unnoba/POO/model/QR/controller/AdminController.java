package ar.edu.unnoba.POO.model.QR.controller;

import ar.edu.unnoba.POO.model.QR.model.Adminitrador;
import ar.edu.unnoba.POO.model.QR.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private IUserService userService;

    @Autowired
    public AdminController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute("username",new Adminitrador());
        return "admin/new";
    }

    @GetMapping
    public String index(Model model, Authentication authentication){
        Adminitrador sessionUser = (Adminitrador) authentication.getPrincipal();
        List<Adminitrador> admin = userService.getAll();
        model.addAttribute("admin",admin);
        model.addAttribute("sessionUser",sessionUser);
        return "admin/index";
    }

    @PostMapping
    public String create(@ModelAttribute Adminitrador user){
        userService.create(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         Authentication authentication,
                         RedirectAttributes redirectAttributes){

        userService.delete(id);
        return "redirect:/admin";
    }






}
