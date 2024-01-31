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
    private final ManufacturerService
            service;
//minuto 31:46
    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }
    /*GET http://localhost:8080/api/manufacturers
    * */
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
         */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id){
        return  this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity
                        //si no encutra el id devuelve un not found
                        .notFound()
                        .build());


    }
    //Le envias al cuerpo un fabricante(evitas crearte el objeto  )
    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer>crate (@RequestBody Manufacturer manufacturer){
        //comprobaciones
        if (manufacturer.getId()!=null)
            return ResponseEntity.badRequest().build();

        //una vez lo guardas le asigna una clave primaria
        this.service.save(manufacturer);
       //y aqui lo devuelve con la clave primaria(id)
        return ResponseEntity.ok(manufacturer);
    }
@PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer>update (@RequestBody Manufacturer manufacturer){
    this.service.save(manufacturer);
    return ResponseEntity.ok(manufacturer);
    }

    @DeleteMapping("/manufacturers/{identifier}")
    public ResponseEntity<Manufacturer>deleteById (@PathVariable ("identifier") Long id){
        this.service.deleteById(id);

        return ResponseEntity.noContent().build();
    }



}
