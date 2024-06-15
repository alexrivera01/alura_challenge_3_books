package com.alura.challenge_books.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTOGutedex(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int fecha_nacimiento,
        @JsonAlias("death_year") int fecha_muerte
) {
}
