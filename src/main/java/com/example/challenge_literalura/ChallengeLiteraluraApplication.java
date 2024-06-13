package com.example.challenge_literalura;

import com.example.challenge_literalura.principal.Principal;


import com.example.challenge_literalura.repository.Repositorio;
import com.example.challenge_literalura.repository.RepositorioAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraluraApplication implements CommandLineRunner {

	@Autowired
	private Repositorio repositorio;
	@Autowired
	private RepositorioAutor repositorioAutor;
	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio,repositorioAutor);
		principal.exibeMenu();
	}
}
