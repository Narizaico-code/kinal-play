package org.jrae.kinal_play.persistence;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.repository.PeliculaRepository;
import org.jrae.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.jrae.kinal_play.web.mapper.PeliculaMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    // 3


    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPelicula.findAll());
    }

    @Override
    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo) {
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));
    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        // Instanciar clase de Entidad
        PeliculaEntity pelicula = new PeliculaEntity();
        // Convertir Dto a Entity
        pelicula = this.peliculaMapper.toEntity(peliculaDto);
            pelicula.setEstado("D");
        // Guardar en la DB con JPA
        this.crudPelicula.save(pelicula);
        // Retornar el valor guardado como Dto
        return this.peliculaMapper.toDto(pelicula);
    }

    @Override
    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
        // Primero obtenemos PeliculaEntity con el codigo
        PeliculaEntity pelicula = this.crudPelicula.findById(codigo).orElse(null);
        // Modificar atributos en ella con datos del mod
        pelicula.setNombre(modPeliculaDto.name());
        pelicula.setFechaEstreno(modPeliculaDto.releaseDate());
        pelicula.setCalificacion(BigDecimal.valueOf(modPeliculaDto.rating()));
        // Guardamos en la DB
        this.crudPelicula.save(pelicula);
        // Retornamos el PeliculaDto convertido de la entidad
        return this.peliculaMapper.toDto(pelicula);
    }
}
