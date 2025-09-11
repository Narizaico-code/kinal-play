package org.jrae.kinal_play.dominio.exception;

public class PeliculaNoExisteException extends RuntimeException{
    public PeliculaNoExisteException (Long codigoPelicula){
        super("La pelicula con codigo: " + codigoPelicula + " no existe en el sistema");
    }
}
