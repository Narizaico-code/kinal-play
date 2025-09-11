package org.jrae.kinal_play.web.controller;

import org.apache.coyote.Response;
import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerTodo(){
        // 200: Ok, todoo funciono correctamente
        // 404: No lo encuentra, no existe, mal nombre
        // 500: Error interno del servidor
        // 405: Metodo de solicitud incorrecto
        //return this.peliculaService.obtenerTodo();
        return ResponseEntity.ok(this.peliculaService.obtenerTodo());
    }

    // 4
    @GetMapping("{codigo}")
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo(@PathVariable Long codigo){
        // return this.peliculaService.obtenerPeliculaPorCodigo(codigo);
        return ResponseEntity.ok(this.peliculaService.obtenerPeliculaPorCodigo(codigo));
    }

    // guardar pelicula
    @PostMapping
    public ResponseEntity<PeliculaDto> guardarPelicula(@RequestBody PeliculaDto peliculaDto){
        // return this.peliculaService.guardarPelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.peliculaService.guardarPelicula(peliculaDto));
    }
    // modificar pelicula
    @PutMapping("{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula(@PathVariable Long codigo, @RequestBody ModPeliculaDto modPeliculaDto){
        return ResponseEntity.ok(this.peliculaService.modificarPelicula(codigo, modPeliculaDto));
    }
    // eliminar pelicula
    @DeleteMapping("{codigo}")
    public ResponseEntity<PeliculaDto> eliminarPelicula(@PathVariable Long codigo){
        return ResponseEntity.ok(this.peliculaService.eliminarPelicula(codigo));
    }
    // excepciones - PeliculaNoExisteException, PeliculaYaExisteException

    // Consulta a la IA

    // validaciones (dependencias)

    // Documentacion (dependencias)
}
