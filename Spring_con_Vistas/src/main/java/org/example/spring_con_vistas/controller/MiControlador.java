package org.example.spring_con_vistas.controller;


import org.example.spring_con_vistas.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MiControlador {
    @GetMapping("/")
    public String index(Map<String, Object> map) {
        //model.addAttribute("titulo", "Programa de prueba");
        map.put("titulo", "Programa de prueba");
        return "index";
    }

    //    @Controller
//    @RequestMapping("/app")
//    public class IndexController{
//
//    }
    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario("Fran", "Garcia", "fran@iessanvicente.com");
        model.addAttribute("titulo", "Pagina del perfil");
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @RequestMapping(value = "/listar")
    public String listar(Model model) {
//        List<Usuario> usuarios=new ArrayList<>();
//        usuarios.add(new Usuario("Fran","Garcia","fran@fran.com"));
//        usuarios.add(new Usuario("Dani","Garcia","dani@dani.com"));
//        usuarios.add(new Usuario("Consulo","Lopez","consu@consu.com"));
//        model.addAttribute("usuarios",usuarios);
        model.addAttribute("titulo", "Listado de usuarios");
        return "listar";

    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Fran", "Garcia", "fran@fran.com"));
        usuarios.add(new Usuario("Dani", "Garcia", "dani@dani.com"));
        usuarios.add(new Usuario("Consulo", "Lopez", "consu@consu.com"));
        return usuarios;
    }
//    enviar parámetros a nuestros controladores


}