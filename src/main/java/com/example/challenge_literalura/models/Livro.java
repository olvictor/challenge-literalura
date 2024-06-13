package com.example.challenge_literalura.models;

import jakarta.persistence.*;

@Table
@Entity(name= "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Autor autor;

    private String idioma;
    private Integer numeroDeDownloads;

    public Livro(){}
    public Livro(String titulo, Autor autor, String idiomas, Integer numeroDeDownloads) {
        this.titulo = titulo;
        this.idioma = idiomas;
        this.autor = autor;
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idioma;
    }

    public void setIdiomas(String idiomas) {
        this.idioma = idiomas;
    }

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    @Override
    public String toString() {
        return "---------- LIVRO ---------- \n"+
                "Ttulo=" + titulo + '\n' +
                "Autor=" + autor.getNome() + '\n' +
                "Idioma=" + idioma + '\n' +
                "Número De Downloads=" + numeroDeDownloads;

    }
}
