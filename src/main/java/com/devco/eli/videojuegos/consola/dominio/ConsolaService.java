package com.devco.eli.videojuegos.consola.dominio;



import com.devco.eli.videojuegos.consola.infraestructura.Consola;
import com.devco.eli.videojuegos.consola.infraestructura.ConsolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsolaService {


    @Autowired
    ConsolaRepository consolaRepository;

    public List<Consola> getConsolas() {return consolaRepository.findAll();}

    public Optional<Consola> getConsola(Long id) {return consolaRepository.findById(id);}

    public void saveOrUpdate(Consola consola){
        consolaRepository.save(consola);
    }

    public void delete(Long id) { consolaRepository.deleteById(id);}
}
