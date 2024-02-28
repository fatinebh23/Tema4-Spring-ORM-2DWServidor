package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Direccion;
import org.example.orm_gestion_instituto.repository.AlumnoRepository;

import java.util.List;

public interface DireccionService {
    List<Direccion> getAllDirecciones();

    void saveDireccion(Direccion direccion);
}
