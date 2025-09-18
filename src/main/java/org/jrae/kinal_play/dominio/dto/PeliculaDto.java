package org.jrae.kinal_play.dominio.dto;

import jakarta.validation.constraints.*;
import org.jrae.kinal_play.dominio.Genre;

import java.time.LocalDate;

public record PeliculaDto(

        Long codigo,
        @NotBlank(message = "El nombre o titulo es obligatorio")
        @Size(min = 5, max = 151, message = "El nombre no debe contener menos de 5 caracteres y no más de 150")
        String name,
        @Min(value = 40, message = "La pelicula no puede durar menos de 40 minutos")
        Integer duration,
        @NotNull(message = "Genero invalido")
        Genre genre,
        @PastOrPresent(message = "La fecha no es valida")
        LocalDate releaseDate,
        @Max(value = 10, message = "La calificacion no debe superar los 10 puntos")
        Double rating,
        @NotNull(message = "Estado invalido, ingrese D(Disponible) ó N(No disponible)")
        Boolean state
) {
}
