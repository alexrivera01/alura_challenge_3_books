package com.alura.challenge_books.repository;

import com.alura.challenge_books.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
}
