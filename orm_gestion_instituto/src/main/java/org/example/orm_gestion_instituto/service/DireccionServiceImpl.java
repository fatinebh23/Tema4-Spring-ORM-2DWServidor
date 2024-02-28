package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Direccion;
import org.example.orm_gestion_instituto.repository.DireccionRepository;

import java.util.List;

public class DireccionServiceImpl implements DireccionService{
    private final DireccionRepository repository;

    public DireccionServiceImpl(DireccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Direccion> getAllDirecciones() {
        return null;
    }

    @Override
    public void saveDireccion(Direccion direccion) {
        this.repository.save(direccion);
    }
}
