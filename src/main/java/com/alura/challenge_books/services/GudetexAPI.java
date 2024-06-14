package com.alura.challenge_books.services;

public class GudetexAPI {
    ClienteHttp clienteHttp = new ClienteHttp();

    public void obtenerJson(){
        String url = "https://gutendex.com/books/?search=quijote";
        System.out.println(clienteHttp.obtenerJson(url));
    }
}
