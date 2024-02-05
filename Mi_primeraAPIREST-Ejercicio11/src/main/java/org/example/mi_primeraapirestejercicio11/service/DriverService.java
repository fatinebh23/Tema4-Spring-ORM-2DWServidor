package org.example.mi_primeraapirestejercicio11.service;

import org.example.mi_primeraapirestejercicio11.module.Driver;

import java.util.List;
//El servicio es el intermediario entre el repositorio y el controlador, que gestionará las peticiones de la API en
//el siguiente apartado.
public interface DriverService {
    List<Driver> getAllDrivers();
}
