package org.example.mi_primeraapirestejercicio11.service;

import org.example.mi_primeraapirestejercicio11.module.Driver;
import org.example.mi_primeraapirestejercicio11.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Esta interfaz define un único método, el cuál será implementado por la clase DriverServiceImpl, el cuál
//tendrá la anotación @Service para indicar que es un servicio y también la anotación @Autowired para
//inyectar el repositorio y hacer uso de él:
@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository repository;
    @Autowired
    public DriverServiceImpl(DriverRepository repository){
        this.repository=repository;
    }


    @Override
    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }
}
