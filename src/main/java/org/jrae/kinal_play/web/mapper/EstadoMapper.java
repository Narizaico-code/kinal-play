package org.jrae.kinal_play.web.mapper;

import org.mapstruct.Named;

public class EstadoMapper {
    @Named("generarState")
    static Boolean generarState(String estado){
        if (estado == null){
            return null;
        }else if (estado.toUpperCase().equals("D")){
            return true;
        }else {
            return false;
        }
    }
    @Named("generarEstado")
    static String generarEstado(Boolean state){
        if (state == null){
            return null;
        } else if (state == true) {
            return "D";
        }else{
            return "N";
        }
    }
}
