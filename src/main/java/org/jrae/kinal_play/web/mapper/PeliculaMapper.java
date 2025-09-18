package org.jrae.kinal_play.web.mapper;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel="spring", uses = {GenreMapper.class, EstadoMapper.class})
public interface PeliculaMapper {

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "duracion", target = "duration" )
    @Mapping(source = "genero", target = "genre", qualifiedByName = "generarGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    @Mapping(source = "estado", target = "state", qualifiedByName = "generarState")
    PeliculaDto toDto(PeliculaEntity entity);
    List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities);

    // Metodo para convertir a Entity - toEntity
    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "generarGenero")
    @Mapping(source = "state" ,target = "estado" , qualifiedByName = "generarEstado")
    PeliculaEntity toEntity (PeliculaDto peliculaDto);

    // Auto actualizar el modPeliculaDto a PeliculaEntity
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "releaseDate", target = "fechaEstreno")
    @Mapping(source = "rating", target = "calificacion")
    void modificarEntityFromDto(ModPeliculaDto modPeliculaDto, @MappingTarget PeliculaEntity peliculaEntity);
}