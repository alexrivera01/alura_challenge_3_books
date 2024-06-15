package com.alura.challenge_books.services;

import com.alura.challenge_books.model.Autor;
import com.alura.challenge_books.model.Libro;
import com.alura.challenge_books.repository.AutorRepository;
import com.alura.challenge_books.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository){
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAll(){
        System.out.println("desde libroService");
        List<Libro> libros= this.libroRepository.findAll();
        System.out.println(libros);
        return libros;
    }

    public void save(Libro libro){
        this.libroRepository.save(libro);
    }
}
