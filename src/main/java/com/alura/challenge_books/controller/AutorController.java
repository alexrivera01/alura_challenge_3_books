package com.alura.challenge_books.controller;

import com.alura.challenge_books.model.Autor;
import com.alura.challenge_books.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorController {

    AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    public List<Autor> findAll(){
        return autorService.findAll();
    }


}
