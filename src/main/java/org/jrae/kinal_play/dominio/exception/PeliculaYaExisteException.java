package org.jrae.kinal_play.dominio.exception;

public class PeliculaYaExisteException extends RuntimeException {
    public PeliculaYaExisteException(String peliculaTitulo) {
      super("La pelicula: " + peliculaTitulo + " ya existe en el sistema");
    }
}
