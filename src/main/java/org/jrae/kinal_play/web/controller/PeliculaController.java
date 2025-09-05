package org.jrae.kinal_play.web.controller;

import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.repository.PeliculaRepository;
import org.jrae.kinal_play.dominio.service.PeliculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/peliculas")
    public List<PeliculaDto> obtenerTodo(){
        return this.peliculaService.obtenerTodo();
    }

    @GetMapping("/peliculas/{codigo}")
    public PeliculaDto obtenerPeliculaPorCodigo(@PathVariable Long codigo){
        return this.peliculaService.obtenerPeliculaPorCodigo(codigo);
    }
}
