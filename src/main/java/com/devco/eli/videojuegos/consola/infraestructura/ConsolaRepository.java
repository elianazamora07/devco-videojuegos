package com.devco.eli.videojuegos.consola.infraestructura;

import com.devco.eli.videojuegos.consola.dominio.Consola;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsolaRepository implements IConsolaRepository {

    @Autowired
    private ConsolaJpa jpa;


    @Override
    public Optional<Consola> getById(Long id) {
        Optional<ConsolaEntity> entity = jpa.findById(id);
        return ConsolaMapper.entityToOptionalDomain(entity);
    }

    @Override
    public Optional<Consola> getByname(String name) {
        Optional<ConsolaEntity> entity = jpa.findByNombreConsola(name);
        return ConsolaMapper.entityToOptionalDomain(entity);
    }

    @Override
    public List<Consola> getAll() {
        List<ConsolaEntity> entities = jpa.findAll();
        return ConsolaMapper.entityToDominio(entities);
    }

    @Override
    public Consola save(Consola domain) {
        ConsolaEntity entityToSave = ConsolaMapper.dominioToEntity(domain);
        entityToSave = jpa.save(entityToSave);
        return ConsolaMapper.entityToDominio(entityToSave);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
