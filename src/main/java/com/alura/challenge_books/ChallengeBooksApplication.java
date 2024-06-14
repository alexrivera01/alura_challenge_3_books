package com.alura.challenge_books;

import com.alura.challenge_books.services.GudetexAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeBooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBooksApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		GudetexAPI gudetexAPI = new GudetexAPI();
		gudetexAPI.obtenerJson();
	}
}
