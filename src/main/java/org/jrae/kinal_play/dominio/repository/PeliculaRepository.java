package org.jrae.kinal_play.dominio.repository;

import org.jrae.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    // Firmas del mantenimiento de DTO
    // 1 Inicio
    List<PeliculaDto> obtenerTodo();
    PeliculaDto obtenerPeliculaPorCodigo(Long codigo);
}
