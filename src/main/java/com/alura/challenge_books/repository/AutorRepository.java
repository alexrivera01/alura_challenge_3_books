package com.alura.challenge_books.repository;

import com.alura.challenge_books.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Integer> {
}
