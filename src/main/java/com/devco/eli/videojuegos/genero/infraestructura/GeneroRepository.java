package com.devco.eli.videojuegos.genero.infraestructura;

import com.devco.eli.videojuegos.genero.dominio.Genero;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GeneroRepository implements IGeneroRepository {

    @Autowired
    private GeneroJpa jpa;

    @Override
    public Optional<Genero> getById(Long id) {
        Optional<GeneroEntity> entity = jpa.findById(id);
        return GeneroMapper.entityToOptionalDomain(entity);
    }

    @Override
    public Optional<Genero> getByname(String name) {
        Optional<GeneroEntity> entity = jpa.findByNombreGenero(name);
        return GeneroMapper.entityToOptionalDomain(entity);
    }

    @Override
    public List<Genero> getAll() {
        List<GeneroEntity> entities = jpa.findAll();
        return GeneroMapper.entityToDominio(entities);
    }

    @Override
    public List<Genero> getAllByIds(List<Long> ids) {
        List<GeneroEntity> entities = jpa.findAllById(ids);
        return GeneroMapper.entityToDominio(entities);
    }

    @Override
    public Genero save(Genero domain) {
        GeneroEntity entityToSave = GeneroMapper.dominioToEntity(domain);
        entityToSave = jpa.save(entityToSave);
        return GeneroMapper.entityToDominio(entityToSave);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
