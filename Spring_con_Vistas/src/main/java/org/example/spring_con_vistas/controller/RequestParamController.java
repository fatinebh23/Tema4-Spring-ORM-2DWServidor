package org.example.spring_con_vistas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
@RequestMapping("/params")
public class RequestParamController {
    @GetMapping({"/index","/","","/home"})
    public String index(Map<String,Object> map){
        map.put("titulo","titulo desde el modelo");
        return "params/index";
    }
    @GetMapping("/string")
    public String ver(@RequestParam(name = "texto", required=false,defaultValue="Texto de ejemplo")String texto, Model model){
        model.addAttribute("titulo","Ejemplo de RequestParam");
        model.addAttribute("resultado","El texto por parametro es: "+texto);
        return "params/ver";
    }

}

