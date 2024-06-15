package com.alura.challenge_books.controller;

import com.alura.challenge_books.model.Libro;
import com.alura.challenge_books.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroController {

    private LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    public void save(Libro libro){
        libroService.save(libro);
    }

    public List<Libro> findAll(){
        return libroService.findAll();
    }

}
