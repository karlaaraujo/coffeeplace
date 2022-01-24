package com.coffeeplace.cpweb.controladores;

import com.coffeeplace.cpweb.persistencia.entidades.Usuario;
import com.coffeeplace.cpweb.persistencia.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.logging.Logger;

@Controller
public class UsuarioControlador {

    private static final Logger LOGGER = Logger.getLogger(UsuarioControlador.class.getName());

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
    public String salvarUsuario(@ModelAttribute Usuario usuario, BindingResult errors, Model model) {
        usuarioRepositorio.save(
                new Usuario(
                        usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getSenha()
                )
        );
        LOGGER.info("Usuario salvo: " + usuario);
        return "success";
    }

    @GetMapping("/usuarios")
    public String getUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepositorio.findAll());
        return "usuarios";
    }

}
