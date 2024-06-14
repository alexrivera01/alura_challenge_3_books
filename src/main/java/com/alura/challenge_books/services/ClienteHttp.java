package com.alura.challenge_books.services;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ClienteHttp {
    HttpClient client = HttpClient.newHttpClient();

    public String obtenerJson(String url){

        String json = "";
        URI uri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()==200){
                json = response.body();
            }

        } catch (IOException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return json;
    }


}
