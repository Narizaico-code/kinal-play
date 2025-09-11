package org.jrae.kinal_play.dominio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ModPeliculaDto(
        String name,
        LocalDate releaseDate,
        Double rating
) {
}
