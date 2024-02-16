package org.example.spring_con_vistas.controller;


import org.example.spring_con_vistas.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Controller
public class MiControlador {
    @GetMapping("/")
    public String index(Map<String, Object>map) {
        //model.addAttribute("titulo", "Programa de prueba");
        map.put("titulo","Programa de prueba");
        return "index";
    }
//    @Controller
//    @RequestMapping("/app")
//    public class IndexController{
//
//    }
    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario =new Usuario("Fran","Garcia","fran@iessanvicente.com");
        model.addAttribute("titulo","Pagina del perfil");
        model.addAttribute("usuario",usuario);
        return "perfil";
    }

}
