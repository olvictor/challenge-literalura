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

}
