package org.jrae.kinal_play.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "Peliculas", description = "Operaciones (CRUD) sobre las peliculas de Kinal-Play")
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
    @Operation(
            summary = "Obtener una pelicula a partir de su identificador",
            description = "Retorna la pelicula que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula fue encontrada con exito"),
                    @ApiResponse(responseCode = "404" , description = "Pelicula no encontrada", content = @Content),
                    @ApiResponse(responseCode = "500" , description = "Hubo un problema con el servidor, revise el mensaje")
            }
    )
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo
    (@Parameter(description = "Identificador de la pelicula a recuperar", example = "1") @PathVariable Long codigo){
        // return this.peliculaService.obtenerPeliculaPorCodigo(codigo);
        return ResponseEntity.ok(this.peliculaService.obtenerPeliculaPorCodigo(codigo));
    }

    // guardar pelicula
    @PostMapping
    public ResponseEntity<PeliculaDto> guardarPelicula
        (@RequestBody @Valid PeliculaDto peliculaDto){
        // return this.peliculaService.guardarPelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.peliculaService.guardarPelicula(peliculaDto));
    }
    // modificar pelicula
    @PutMapping("{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula
        (@PathVariable Long codigo, @RequestBody @Valid ModPeliculaDto modPeliculaDto){
        return ResponseEntity.ok(this.peliculaService.modificarPelicula(codigo, modPeliculaDto));
    }
    // eliminar pelicula
    @DeleteMapping("{codigo}")
    public ResponseEntity<PeliculaDto> eliminarPelicula
        (@PathVariable Long codigo){
        this.peliculaService.eliminarPelicula(codigo);
        return ResponseEntity.ok().build();
    }
    // excepciones - PeliculaNoExisteException, PeliculaYaExisteException



    // validaciones (dependencias)

    // Documentacion (dependencias)

    // Consulta a la IA
}
