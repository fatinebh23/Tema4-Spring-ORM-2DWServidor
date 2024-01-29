package org.example.springapirest.service;

import org.example.springapirest.model.Manufacturer;

import java.util.List;
import java.util.Optional;
/*CRUD:
Create
Retrieve / Read
Update
 Delete*/
public interface ManufacturerService {

    //RETRIVE(CONSULTA)
    List<Manufacturer>findAll();
    List<Manufacturer>findAllYear(Integer year);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> findByName(String name);

    //CREATE / UPDATE
    Manufacturer save(Manufacturer manufacturer);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

    //Mas logica de negocio

    //1.Coches fabricados
    //2.Beneficios obtenidos
    //3. ....

}
