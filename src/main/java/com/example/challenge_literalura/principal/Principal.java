package com.example.challenge_literalura.principal;

import com.example.challenge_literalura.services.Dados;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
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
    public void exibeMenu(){
        while(opcao != 0){
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao){
                case 1:
                    buscarDados();
                    break;
                case 0:
                    opcao = 0;
                    break;
            }
        }
    }


    public String buscarDados(){
       Dados dados = new Dados();
       String resposta;
       System.out.println("digite o nome do Livro : ");
       var livro = leitura.nextLine();

       var url = "https://gutendex.com/books/?search="+ livro.replace(" ","%20");


        try {
            resposta = dados.obterDados(url);
          System.out.println(resposta);
         return resposta;
     } catch (IOException e) {
            throw new RuntimeException(e);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
}
