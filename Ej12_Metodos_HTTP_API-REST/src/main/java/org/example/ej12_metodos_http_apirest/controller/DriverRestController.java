package org.example.ej12_metodos_http_apirest.controller;

import org.example.ej12_metodos_http_apirest.module.Driver;
import org.example.ej12_metodos_http_apirest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class DriverRestController {
    private final DriverService driverService;
    @Autowired
    public DriverRestController(DriverService service){
        this.driverService=service;

    }
    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAll(){
        return ResponseEntity.ok(driverService.getAllDrivers());

    }
//    Get http://localhost:8080/api/drivers/alo

//PathVariable es una anotación de Spring que se utiliza para extraer valores de la URL y asignarlos
//    a parámetros de método en el controlador. En el código, @PathVariable String code indica que el
//    valor de la variable code se tomará de la porción de la URL que coincide con /drivers/code/{code}.
//    Por ejemplo, si la URL es /drivers/code/alo, entonces code tomará el valor "alo".
    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code){
        return this.driverService.getDriverByCode(code)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());


    }
//POST
    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver){
       if (driver.getDriverId()!=null)
           return ResponseEntity.badRequest().build();

       this.driverService.saveDriver(driver);
       return  ResponseEntity.ok(driver);


    }
//PUT
    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver){

        this.driverService.saveDriver(driver);
        return  ResponseEntity.ok(driver);


    }

    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code){

        this.driverService.deleteDriverByCode(code);
        return  ResponseEntity.noContent().build();


    }

}
