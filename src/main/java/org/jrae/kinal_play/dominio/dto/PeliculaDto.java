package org.jrae.kinal_play.dominio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.jrae.kinal_play.dominio.Genre;

import java.time.LocalDate;

public record PeliculaDto(

        Long codigo,
        @NotBlank(message = "El nombre o titulo es obligatorio")
        String name,
        @Min(value = 60, message = "La pelicula no puede durar menos de 60 minutos")
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean state
) {
}
