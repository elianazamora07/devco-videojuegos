package com.devco.eli.videojuegos.consola.dominio;

import com.devco.eli.videojuegos.comun.errores.NotFoundRequest;
import com.devco.eli.videojuegos.consola.dominio.dto.ConsolaDto;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaRepository;
import com.devco.eli.videojuegos.consola.dominio.port.IConsolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsolaService implements IConsolaService {

    private static final String CONSOLA_NO_ENCONTRADA = "No se encontro la consola con el ID ";

    @Autowired
    IConsolaRepository consolaRepository;

    @Override
    public Consola getById(Long id) {
        Optional<Consola> consola = consolaRepository.getById(id);
        if (consola.isEmpty()) {
            throw new NotFoundRequest(CONSOLA_NO_ENCONTRADA + id);
        }
        return consola.get();
    }

    @Override
    public List<Consola> getAll() {
        return consolaRepository.getAll();
    }

    @Override
    public Consola createOrUpdate(ConsolaDto dto) {
        Optional<Consola> consola = consolaRepository.getByname(dto.getNombre());
        Consola consolaToSave;
        if (consola.isEmpty()) {
            consolaToSave = new Consola();
            consolaToSave.setCreateAt(LocalDateTime.now());
        } else {
            consolaToSave = consola.get();
        }
        consolaToSave.setNombre(dto.getNombre());
        consolaToSave.setUpdateAt(LocalDateTime.now());
        return consolaRepository.save(consolaToSave);
    }

    public void delete(Long id) {
        consolaRepository.deleteById(id);
    }
}
