package org.jrae.kinal_play.web.mapper;

import org.jrae.kinal_play.dominio.Genre;

public class GenreMapper {
    public static Genre generarGenre(String genero){
        if (genero == null) return null;
        return switch (genero.toUpperCase()){
            case "ACCION" -> Genre.ACTION;
            case "ANIMADA" -> Genre.ANIMATED;
            case "CIENCIA_FICCION" -> Genre.SCI_FY;
            case "CRIMEN" -> Genre.CRIME;
            case "DRAMA" -> Genre.DRAMA;
            case "DRAMA_BELICO" -> Genre.BELIC_DRAMA;
            case "FANTASIA" -> Genre.FANTASY;
            case "SUSPENSO" -> Genre.SUSPENSE;
            case "TERROR" -> Genre.HORROR;
            default -> null;
        };
    }
}
