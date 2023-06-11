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
        Optional<GeneroEntity> generoEntity = jpa.findById(id);
        return GeneroMapper.entityToOptionalDomain(generoEntity);
    }

    @Override
    public Optional<Genero> getByname(String name) {
        Optional<GeneroEntity> generoEntity = jpa.findByNombreGenero(name);
        return GeneroMapper.entityToOptionalDomain(generoEntity);
    }

    @Override
    public List<Genero> getAll() {
        List<GeneroEntity> generos = jpa.findAll();
        return GeneroMapper.entityToDominio(generos);
    }

    @Override
    public Genero save(Genero genero) {
        GeneroEntity generoToSave = GeneroMapper.dominioToEntity(genero);
        generoToSave = jpa.save(generoToSave);
        return GeneroMapper.entityToDominio(generoToSave);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
