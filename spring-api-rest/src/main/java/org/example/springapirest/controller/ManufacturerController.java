package org.example.springapirest.controller;

import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //devuelve los datos
@RequestMapping("/api")
public class ManufacturerController {
    private ManufacturerService service;

    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }
    /*GET http://localhost:8080/api/manufacturers*/
@GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> findAll(){
    List<Manufacturer> manufacturers = this.service.findAll();
    if (manufacturers.isEmpty())
        return ResponseEntity.notFound().build();

    return ResponseEntity.ok(manufacturers);
    }
}
