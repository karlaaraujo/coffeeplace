package com.coffeeplace.cpweb.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {
    @GetMapping("/")
    public String homePage(Model model) {
        //model.addAttribute("appName", appName);
        return "index";
    }

    @GetMapping("/signin")
    public String signinPage(Model model) {
        //model.addAttribute("appName", appName);
        return "signin";
    }
    @GetMapping("/signup")
    public String signupPage(Model model) {
        //model.addAttribute("appName", appName);
        return "signup";
    }

}
