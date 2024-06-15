package com.alura.challenge_books.model;

import jakarta.persistence.*;

@Entity
public class Libro {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libro_id;
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="autor_id",referencedColumnName = "autor_id")
    private Autor autor;
    private String idioma;
    private int cantidadDeDescargas;

    public Libro(LibroDTOGudetex libroDTOGudetex){
        this.titulo = libroDTOGudetex.titulo();
        this.autor = new Autor(libroDTOGudetex.autor()[0]);
        this.cantidadDeDescargas = libroDTOGudetex.cantidadDeDescargas();
        this.idioma = libroDTOGudetex.idioma()[0];
    }

    public Libro(){

    }

    //region Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(int cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.toString() +
                ", idioma='" + idioma + '\'' +
                ", cantidadDeDescargas=" + cantidadDeDescargas +
                '}';
    }
//endregion
}
