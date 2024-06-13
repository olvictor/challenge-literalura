package com.example.challenge_literalura.repository;

import com.example.challenge_literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioAutor extends JpaRepository<Autor, Long> {

//    @Query("SELECT a from Autor a where a.dataNascimento <= :ano AND a.dataFalecimento >= :ano")
//    List<Autor> atoresVivosEmDeterminadaData(Integer ano);
}
