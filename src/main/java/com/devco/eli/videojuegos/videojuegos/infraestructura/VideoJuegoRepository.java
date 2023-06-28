package com.devco.eli.videojuegos.videojuegos.infraestructura;

import com.devco.eli.videojuegos.videojuegos.dominio.VideoJuego;
import com.devco.eli.videojuegos.videojuegos.dominio.port.IVideoJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VideoJuegoRepository implements IVideoJuegoRepository {

    @Autowired
    private VideojuegoJpa jpa;

    @Override
    public Optional<VideoJuego> getById(Long id) {
        Optional<VideoJuegoEntity> entity = jpa.findById(id);
        return VideoJuegoMapper.entityToOptionalDomain(entity);
    }

    @Override
    public List<VideoJuego> getAll() {
        List<VideoJuegoEntity> entities = jpa.findAll();
        return VideoJuegoMapper.entityToDominio(entities);
    }

    @Override
    public VideoJuego save(VideoJuego domain) {
        VideoJuegoEntity entityToSave = VideoJuegoMapper.dominioToEntity(domain);
        entityToSave = jpa.save(entityToSave);
        return VideoJuegoMapper.entityToDominio(entityToSave);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
