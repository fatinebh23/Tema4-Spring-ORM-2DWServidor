package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Modulo;

import java.util.List;

public class ModuloServiceImpl implements ModuloService{
    private final ModuloService repository;

    public ModuloServiceImpl(ModuloService repository) {
        this.repository = repository;
    }

    @Override
    public List<Modulo> getAllModulos() {
        return null;
    }

    @Override
    public void save(Modulo module) {
        
    }


    @Override
    public void saveModule(Modulo module) {
        this.repository.save(module);
    }


}
