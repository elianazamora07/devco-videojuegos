package com.devco.eli.videojuegos.genero.dominio;

import com.devco.eli.videojuegos.common.exceptions.exception.NotFoundRequest;
import com.devco.eli.videojuegos.genero.dominio.dto.GeneroDto;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroRepository;
import com.devco.eli.videojuegos.genero.dominio.port.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GeneroService implements IGeneroService {

    private static final String GENERO_NO_ENCONTRADO = "No se encontro el genero con el ID ";

    @Autowired
    IGeneroRepository generoRepository;

    @Override
    public Genero getById(Long id) {
        Optional<Genero> genero = generoRepository.getById(id);
        if (genero.isEmpty()) {
            throw new NotFoundRequest(GENERO_NO_ENCONTRADO + id);
        }
        return genero.get();
    }

    @Override
    public List<Genero> getAll() {
        return generoRepository.getAll();
    }

    @Override
    public Set<Genero> getAllByIds(Set<Long> ids) {
        return new HashSet<>(generoRepository.getAllByIds(ids));
    }

    @Override
    public Genero createOrUpdate(GeneroDto dto) {
        Optional<Genero> genero = generoRepository.getByname(dto.getNombre());
        Genero generoToSave;
        generoToSave = genero.orElseGet(Genero::new);
        generoToSave.setNombre(dto.getNombre());

        generoToSave.isValid();
        return generoRepository.save(generoToSave);
    }

    @Override
    public void delete(Long id) {
        generoRepository.deleteById(id);
    }
}
