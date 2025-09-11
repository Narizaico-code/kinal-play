package org.jrae.kinal_play.dominio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ModPeliculaDto(
        @NotBlank(message = "El nombre o titulo de la pelicula es obligatorio")
        String name,
        @PastOrPresent(message = "La fecha de lanzamiento debe de ser anterior a la fecha actual")
        LocalDate releaseDate,
        @Min(value = 0, message = "La calificacion no puede ser menor a 0")
        @Max(value = 10, message = "La calificacion no puede ser mayor a 10")
        Double rating
) {
}
