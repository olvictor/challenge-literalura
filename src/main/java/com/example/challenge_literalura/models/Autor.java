package com.example.challenge_literalura.models;

import com.example.challenge_literalura.DTO.autorDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private Integer anoDeNascimento;
    private Integer anoDeFalecimento;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livro;

    public Autor(String nome, LocalDate anoNascimento, LocalDate anoMorte) {
    }

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

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(Integer anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public Integer getAnoDeFalecimento() {
        return anoDeFalecimento;
    }

    public void setAnoDeFalecimento(Integer anoDeFalecimento) {
        this.anoDeFalecimento = anoDeFalecimento;
    }

    public Livro getLivros() {
        return (Livro) livro;
    }

    public void setLivros(Livro livros) {
        this.livro = (List<Livro>) livros;
    }

    public Autor(){}
    public Autor(String nome, Integer anoDeNascimento, Integer anoDeFalecimento) {
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
        this.anoDeFalecimento = anoDeFalecimento;
    }
    public static Autor fromDTO(autorDTO autorDTO) {
        return new Autor(String.valueOf(autorDTO.getNome()), autorDTO.getAnoNascimento(), autorDTO.getAnoMorte());
    }
    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", anoDeNascimento=" + anoDeNascimento +
                ", anoDeFalecimento=" + anoDeFalecimento +
                ", livros=" + livro ;
    }
}
