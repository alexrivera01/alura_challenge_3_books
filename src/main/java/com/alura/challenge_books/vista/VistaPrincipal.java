package com.alura.challenge_books.vista;

import com.alura.challenge_books.controller.PrincipalController;
import com.alura.challenge_books.model.Autor;
import com.alura.challenge_books.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

public class VistaPrincipal {

    PrincipalController principalController;


    public VistaPrincipal( PrincipalController principalController){
        this.principalController = principalController;
    }



    public void menuPrincipal(){
        int opcion = -1;
        do {
            imprimirMenuPrincipal();
            opcion = obtenerYVerificarOpcion();
            if(opcion == 0){
                System.out.println("Programa terminado");
                break;
            }
            procesarOpcion(opcion);
        }
        while (true);

    }

    public void imprimirMenuPrincipal(){
        imprimir("Menu principal");
        imprimir("1- Buscar libro por titulo");
        imprimir("2- Listar libros buscados");
        imprimir("3- Listar autores registrados");
        imprimir("4- Listar autores vivos en un determinado año");
        imprimir("5- Listar libros por idioma");
        imprimir("0- salir");
    }

    public int obtenerYVerificarOpcion(){
        int opcion = -1;
        do{
            opcion = obtenerOpcion("Digite su opción: ");
            if(opcion<=-1 || opcion>5){
                imprimir("Elija una opción correcta");
            }
        }while (opcion<=-1 || opcion>5);
        return opcion;
    }

    public void procesarOpcion(int opcion){
        switch (opcion){
            case 1:
                menuOpcion1();
                break;
            case 2:
                enviarDatosAControlador(2);
                break;
            case 3:
                enviarDatosAControlador(3);
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    private void menuOpcion1() {
        String nombreLibro = obtenerCadena("Digite el nombre del libro: ");
        enviarDatosAControlador(1,nombreLibro);
    }

    public void mostrarLibrosGuardados(List<Libro> libros){
        for(Libro libro : libros){
            mostrarLibroBuscado(libro);
        }
    }

    public void mostrarAutoresGuardados(List<Autor> autores){
        for(Autor autor : autores){
            imprimir("------");
            imprimir("Autor: "+autor.getNombre());
            imprimir("Fecha nacimiento : "+autor.getNombre());
            imprimir("Fecha fallecimiento: : "+autor.getNombre());
            imprimir("");
        }
    }

    private void enviarDatosAControlador(int opcion, String...args){
        this.principalController.procesarDatos(opcion,args);
    }


    public void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public int obtenerOpcion(String mensaje){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        System.out.printf(mensaje);
        try {
            opcion = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Solo se admiten números");
            scanner.nextLine();
        }
        return opcion;
    }

    public String obtenerCadena(String mensaje){
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        System.out.printf(mensaje);
        try {
            opcion = scanner.nextLine();
        }catch (Exception e){
            System.out.println("Verifica tu entrada"+e.getMessage());
            scanner.nextLine();
        }
        return opcion;
    }

    public void mostrarLibroBuscado(Libro libro) {
        imprimir("---- LIBRO ----");
        imprimir("Titulo:"+libro.getTitulo());
        imprimir("Autor:"+libro.getAutor().getNombre());
        imprimir("Idioma:"+libro.getIdioma());
        imprimir("Descargas:"+libro.getCantidadDeDescargas());
        imprimir("----------------");
        imprimir("");
    }
}
