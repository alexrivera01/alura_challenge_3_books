package com.alura.challenge_books;

import com.alura.challenge_books.controller.PrincipalController;
import com.alura.challenge_books.services.GudetexAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeBooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBooksApplication.class, args);
	}
	@Autowired  PrincipalController principalController;

	@Override
	public void run(String... args) throws Exception {
		principalController.iniciar();

		//GudetexAPI gudetexAPI = new GudetexAPI();
		//gudetexAPI.obtenerLibro();
	}
}
