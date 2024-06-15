package com.alura.challenge_books.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autor_id;
    private String nombre;
    private int fecha_nacimiento;
    private int fecha_muerte;

    public Autor(AutorDTOGutedex autorDTOGutedex) {
        this.nombre = autorDTOGutedex.nombre();
        this.fecha_nacimiento = autorDTOGutedex.fecha_nacimiento();
        this.fecha_muerte = autorDTOGutedex.fecha_muerte();
    }

    public Autor(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(int fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getFecha_muerte() {
        return fecha_muerte;
    }

    public void setFecha_muerte(int fecha_muerte) {
        this.fecha_muerte = fecha_muerte;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", fecha_muerte=" + fecha_muerte +
                '}';
    }
}
