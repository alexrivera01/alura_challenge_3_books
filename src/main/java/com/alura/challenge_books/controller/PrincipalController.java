package com.alura.challenge_books.controller;

import com.alura.challenge_books.model.Libro;
import com.alura.challenge_books.services.AutorService;
import com.alura.challenge_books.services.GudetexAPI;
import com.alura.challenge_books.services.LibroService;
import com.alura.challenge_books.vista.VistaPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Component
public class PrincipalController {

    private ApiController apiController;
    private LibroController libroController;
    private AutorController autorController;

    private VistaPrincipal vistaPrincipal;


    @Autowired
    public PrincipalController(AutorController autorController, LibroController libroController, GudetexAPI gudetexAPI, ApiController apiController){
        this.vistaPrincipal = new VistaPrincipal(this);
        this.libroController = libroController;
        this.apiController = apiController;
        this.autorController = autorController;
    }

    public void iniciar(){
        vistaPrincipal.menuPrincipal();

        //Optional<Libro> libroOptional= apiController.obtenerLibro();
        
        //libroOptional.ifPresent(libro -> libroService.save(libro));
    }


    public void procesarDatos(int opcion, String...args) {
        switch (opcion){
            case 1:
               Optional<Libro> libroOptional = apiController.obtenerLibro(args[0]);
               if(libroOptional.isPresent()){
                   Libro libro = libroOptional.get();
                   vistaPrincipal.mostrarLibroBuscado(libro);
                   libroController.save(libro);
               }else {
                   vistaPrincipal.imprimir("No encontrado");
                   vistaPrincipal.menuPrincipal();
               }
                break;
            case 2:
                vistaPrincipal.mostrarLibrosGuardados(libroController.findAll());
                break;
            case 3:
                vistaPrincipal.mostrarAutoresGuardados(autorController.findAll());
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                break;
        }
    }



}
