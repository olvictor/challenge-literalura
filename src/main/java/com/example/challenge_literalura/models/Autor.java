package com.example.challenge_literalura.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "autores")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate anoDeNascimento;
    private LocalDate anoDeFalecimento;
    @OneToMany
    private Livro livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(LocalDate anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public LocalDate getAnoDeFalecimento() {
        return anoDeFalecimento;
    }

    public void setAnoDeFalecimento(LocalDate anoDeFalecimento) {
        this.anoDeFalecimento = anoDeFalecimento;
    }

    public Livro getLivros() {
        return livros;
    }

    public void setLivros(Livro livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoDeNascimento=" + anoDeNascimento +
                ", anoDeFalecimento=" + anoDeFalecimento +
                ", livros=" + livros +
                '}';
    }
}
