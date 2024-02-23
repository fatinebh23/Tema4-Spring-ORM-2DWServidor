package org.example.ej12_metodos_http_apirest.service;

import org.example.ej12_metodos_http_apirest.module.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();

    Optional<Driver> getDriverByCode(String code);

    //CREATE / UPDATE
    void saveDriver(Driver driver);

    //DELETE
    void deleteDriverByCode(String code);

}
