package com.alura.challenge_books.services;

import com.alura.challenge_books.model.Autor;
import com.alura.challenge_books.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public List<Autor> findAll(){
        return this.autorRepository.findAll();
    }

    public void save(Autor autor){
        this.autorRepository.save(autor);
    }




}
