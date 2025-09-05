package org.jrae.kinal_play.persistence;

import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.repository.PeliculaRepository;
import org.jrae.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.jrae.kinal_play.web.mapper.PeliculaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class PeliculaEntityRepository implements PeliculaRepository {

    private final CrudPeliculaEntity crudPelicula;
    private final PeliculaMapper peliculaMapper;

    // Inyeccion de dependencias implicito: Sin el Autowired
    public PeliculaEntityRepository(CrudPeliculaEntity crudPelicula, PeliculaMapper peliculaMapper) {
        this.crudPelicula = crudPelicula;
        this.peliculaMapper = peliculaMapper;
    }


    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPelicula.findAll());
    }

    @Override
    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo) {
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));
    }
}
