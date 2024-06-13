package com.example.challenge_literalura.principal;

import com.example.challenge_literalura.DTO.livroDTO;

import com.example.challenge_literalura.models.Autor;
import com.example.challenge_literalura.models.Livro;
import com.example.challenge_literalura.repository.Repositorio;
import com.example.challenge_literalura.repository.RepositorioAutor;
import com.example.challenge_literalura.services.Dados;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Repositorio repositorio;
    private RepositorioAutor repositorioAutor;
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

    public Principal(Repositorio repositorio, RepositorioAutor repositorioAutor) {
        this.repositorio = repositorio;
        this.repositorioAutor = repositorioAutor;
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
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLivrosEmUmDeterminadoIdioma();
                    break;
                case 0:
                    opcao = 0;
                    break;
            }
        }
    }

    private void listarLivrosEmUmDeterminadoIdioma() {
        System.out.println("""
                Em qual idioma deseja pesquisar? (digite a sigla)
                es -  Espanhol
                en -  Inglês
                fr -  Francês
                pt -  Português
                """);
        var idioma = leitura.nextLine();
        var livros = repositorio.findAll();
        List<Livro> livrosIdioma = livros.stream()
                .filter(l -> Objects.equals(l.getIdiomas(), idioma))
                .collect(Collectors.toList());
        if(livrosIdioma.isEmpty()){
                    System.out.println("Não existem livros nesse idioma em nosso banco de dados .");
        }
        livrosIdioma.forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.println("Insira o ano que deseja pesquisar :");
        var ano = leitura.nextInt();
        leitura.nextLine();
        var autores = repositorioAutor.findAll();
        var autoresVIvos =  autores.stream()
                    .filter(a -> a.getAnoDeNascimento() <= ano && a.getAnoDeFalecimento() >= ano )
                    .collect(Collectors.toList());
        if(autoresVIvos.isEmpty()){
            System.out.println("Nenhum autor encotrado em nosso banco de dados .");
        }
        autoresVIvos.forEach(System.out::println);
    }

    private void listarAutores() {
        var autores = repositorioAutor.findAll();
        autores.stream()
                .forEach(System.out::println);
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

            repositorio.save(livro);
            
     } catch (IOException e) {
            throw new RuntimeException(e);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
}
