package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Modulo;

import java.util.List;

public interface ModuloService {

    List<Modulo> getAllModulos();

    void save(Modulo module);

    void saveModule(Modulo module);
}
