package org.example.spring_con_vistas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/variables")
public class PathVariablesController {
    @GetMapping({"/index","/","","/home"})
    public String index(Map<String,Object> map){
        map.put("titulo","titulo desde el modelo");
        map.put("contenido","Este es el contenido de las variables");

        return "variables/index";
    }


    @GetMapping("/string/{texto}")
    public String ver(@PathVariable String texto,Model model){
        model.addAttribute("titulo","titulo desde string con path variable");
        model.addAttribute("contenido",texto);
        return "variables/ver";
    }


    @GetMapping("/string/{texto}/{numero}")
    public String ver(@PathVariable String texto,@PathVariable Integer numero, Model model){
        model.addAttribute("titulo","Ejemplo 2 parametros");
        model.addAttribute("contenido",texto);
        model.addAttribute("valor",numero);
        return "variables/ver";
    }
}
