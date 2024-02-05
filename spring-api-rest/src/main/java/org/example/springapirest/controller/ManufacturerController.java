package org.example.springapirest.controller;

import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /*
GET http://localhost:8080/api/manufacturers/year/1990
* */
    @GetMapping("/manufacturers/year/{year}")
    public ResponseEntity<List<Manufacturer>> findAllByYear(@PathVariable Integer year){
        List<Manufacturer> manufacturers = this.service.findAllByYear(year);
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(manufacturers);
    }


    /*
    GET http://localhost:8080/api/manufacturers/7
    * */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id){
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /*
     *
     * */


    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer){
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }


    // Las urls no están repetidas porq cada una usa un método http diferente
    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer){
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }


    @DeleteMapping("/manufacturers/{identifier}")
    public ResponseEntity<Manufacturer> deleteById(@PathVariable("identifier") Long id){
        this.service.deleteById(id);
        // Hab´ria que hacer una comprobación de si el manufacturer existe o no y devolver
        // not found o así
        return ResponseEntity.noContent().build();
    }

}
