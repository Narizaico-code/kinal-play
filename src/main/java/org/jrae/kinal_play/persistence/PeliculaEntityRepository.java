package org.jrae.kinal_play.persistence;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.exception.PeliculaNoExisteException;
import org.jrae.kinal_play.dominio.exception.PeliculaYaExisteException;
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
        PeliculaEntity pelicula = this.crudPelicula.findById(codigo).orElse(null);
        if (pelicula == null) {
            throw new PeliculaNoExisteException(codigo);
        }else {
            return this.peliculaMapper.toDto(pelicula);
        }
    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        // Instanciar clase de Entidad
        if (this.crudPelicula.findFirstByNombre(peliculaDto.name()) != null){
            throw new PeliculaYaExisteException(peliculaDto.name());
        }
        // Convertir Dto a Entity
        PeliculaEntity pelicula = this.peliculaMapper.toEntity(peliculaDto);
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
        if (pelicula == null){
            throw new PeliculaNoExisteException(codigo);
        }else {
            this.peliculaMapper.modificarEntityFromDto(modPeliculaDto, pelicula);
            return this.peliculaMapper.toDto(this.crudPelicula.save(pelicula));
        }
    }
    @Override
    public void eliminarPelicula(Long codigo){
        PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
        if (peliculaEntity == null){
            //Excepcion
            throw new PeliculaNoExisteException(codigo);
        }else {
            this.crudPelicula.deleteById(codigo);
        }

    }
}