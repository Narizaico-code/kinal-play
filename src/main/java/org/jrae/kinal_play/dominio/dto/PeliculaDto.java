package org.jrae.kinal_play.dominio.dto;

import org.jrae.kinal_play.dominio.Genre;

import java.time.LocalDate;

public record PeliculaDto(
        String name,
        String duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating
) {
}
