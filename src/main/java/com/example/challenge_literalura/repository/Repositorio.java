package com.example.challenge_literalura.repository;

import com.example.challenge_literalura.models.Autor;
import com.example.challenge_literalura.models.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<Livro,Integer> {
}