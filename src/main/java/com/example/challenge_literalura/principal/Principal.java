package com.example.challenge_literalura.principal;

import com.example.challenge_literalura.DTO.livroDTO;

import com.example.challenge_literalura.models.Autor;
import com.example.challenge_literalura.models.Livro;
import com.example.challenge_literalura.repository.Repositorio;
import com.example.challenge_literalura.services.Dados;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    private Repositorio repositorio;
    private String menu = """
            ------------------------
            
            1- Buscar livro pelo titulo
            2- Listar livros registrados
            3- Listar autores registrados
            4- Listar autores vivos em 1 determinado ano
            5- Listar livros em um determinado idioma
            0- Sair
            """;
    private Integer opcao = -1;
    Scanner leitura = new Scanner(System.in);

    public Principal(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){
        while(opcao != 0){
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao){
                case 1:
                    buscarDados();
                    break;

                case 2:
                    listarLivros();
                    break;
                case 0:
                    opcao = 0;
                    break;
            }
        }
    }

    private void listarLivros() {
      var livros =  repositorio.findAll();
      livros.stream()
              .forEach(System.out::println);
    }


    public void buscarDados(){
       Dados dados = new Dados();
       JsonNode resposta;


       System.out.println("digite o nome do Livro : ");
       var livroBuscar = leitura.nextLine();

       var url = "https://gutendex.com/books/?search="+ livroBuscar.replace(" ","%20");


        try {
            resposta = dados.obterDados(url);
            var livroJSON =  dados.converterDados(String.valueOf(resposta.get(0)), livroDTO.class);
            Autor autor = new Autor(livroJSON.autor().get(0).nome(),livroJSON.autor().get(0).getAnoDeNascimento(),livroJSON.autor().get(0).getAnoDeFalecimento());
            Livro livro = new Livro(livroJSON.titulo(),autor,livroJSON.idiomas().get(0),livroJSON.numeroDeDownloads());

//           System.out.println(livroJSON.autor().get(0).nome());
//           var teste = repositorio.findAll();
//            System.out.println(teste);
//            System.out.println(livro);
//            System.out.println(autor);
            repositorio.save(livro);
            
     } catch (IOException e) {
            throw new RuntimeException(e);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
}
