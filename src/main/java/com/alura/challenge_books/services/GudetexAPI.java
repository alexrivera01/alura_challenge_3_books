package com.alura.challenge_books.services;

import com.alura.challenge_books.model.Libro;
import com.alura.challenge_books.model.LibroDTOGudetex;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GudetexAPI {
    private final ClienteHttp clienteHttp;
    private final ObjectMapper objectMapper;

    @Autowired
    public GudetexAPI(ClienteHttp clienteHttp) {
        this.objectMapper = new ObjectMapper();
        this.clienteHttp = clienteHttp;
    }

    public Optional<Libro> obtenerLibro(String nombreLibro){
        String base = "https://gutendex.com/books/?search=";
        //String url= "http://localhost:8081/response";
        String url = base+nombreLibro;

        String json = clienteHttp.obtenerJson(url);
        Optional<Libro> libroOptional= Optional.empty();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode resultsNode = jsonNode.path("results");

            //!resultsNode.isMissingNode() = esto nos dice que sí  una clave llamada "results" mas no comprueba que está vacia
            if(!resultsNode.isMissingNode() && !resultsNode.isEmpty()){
                LibroDTOGudetex libroDTOGudetex = objectMapper.treeToValue(resultsNode.get(0),LibroDTOGudetex.class);
                Libro libro = new Libro(libroDTOGudetex);
                libroOptional = Optional.of(libro);
            }

        } catch (JsonMappingException e) {
            System.out.println(e.getMessage());
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return libroOptional;

    }
}
