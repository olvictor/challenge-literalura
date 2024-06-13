package com.example.challenge_literalura.repository;

import com.example.challenge_literalura.models.Autor;
import com.example.challenge_literalura.models.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repositorio extends JpaRepository<Livro,Integer> {
    List<Livro> findFirst10ByOrderByNumeroDeDownloadsDesc();
}