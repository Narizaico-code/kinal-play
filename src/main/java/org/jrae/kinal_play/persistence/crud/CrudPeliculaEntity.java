package org.jrae.kinal_play.persistence.crud;

import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudPeliculaEntity extends CrudRepository<PeliculaEntity, Long> {
    // CRUD sustituye a DAO->Transacciones, o el Controller
//    PeliculaEntity findByTitulo(String titulo);
//    PeliculaEntity [metodo interno] + [atributo]
    PeliculaEntity findFirstByNombre(String nombre);
}
