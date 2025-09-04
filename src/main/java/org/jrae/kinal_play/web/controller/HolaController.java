package org.jrae.kinal_play.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundo estoy en Spring Boot";
    }
}
