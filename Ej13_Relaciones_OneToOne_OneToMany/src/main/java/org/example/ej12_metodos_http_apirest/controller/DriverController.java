package org.example.ej12_metodos_http_apirest.controller;

import org.example.ej12_metodos_http_apirest.module.Driver;
import org.example.ej12_metodos_http_apirest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class DriverController {
    private final DriverService driverService;
    @Autowired
    public DriverController(DriverService service){
        this.driverService=service;

    }
    @GetMapping(value = "/listar")
    public String listar(Model model) {
        List<Driver> drivers = driverService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "listar";
    }

}
