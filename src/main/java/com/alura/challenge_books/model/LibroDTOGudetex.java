package com.alura.challenge_books.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTOGudetex(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") AutorDTOGutedex[] autor,
        @JsonAlias("languages") String[] idioma,
        @JsonAlias("download_count") int cantidadDeDescargas
) {
}
