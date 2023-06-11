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
        Optional<ConsolaEntity> consolaEntity = jpa.findById(id);
        return ConsolaMapper.entityToOptionalDomain(consolaEntity);
    }

    @Override
    public Optional<Consola> getByname(String name) {
        Optional<ConsolaEntity> consolaEntity = jpa.findByNombreConsola(name);
        return ConsolaMapper.entityToOptionalDomain(consolaEntity);
    }

    @Override
    public List<Consola> getAll() {
        List<ConsolaEntity> consolas = jpa.findAll();
        return ConsolaMapper.entityToDominio(consolas);
    }

    @Override
    public Consola save(Consola consola) {
        ConsolaEntity consolaToSave = ConsolaMapper.dominioToEntity(consola);
        consolaToSave = jpa.save(consolaToSave);
        return ConsolaMapper.entityToDominio(consolaToSave);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
