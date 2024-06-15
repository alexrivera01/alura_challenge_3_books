package com.alura.challenge_books.controller;

import com.alura.challenge_books.model.Libro;
import com.alura.challenge_books.services.GudetexAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApiController {
    private GudetexAPI gudetexAPI;

    @Autowired
    public ApiController(GudetexAPI gudetexAPI){
        this.gudetexAPI = gudetexAPI;
    }

    public Optional<Libro> obtenerLibro(String nombreLibro){
        return gudetexAPI.obtenerLibro(nombreLibro);
    }

}
