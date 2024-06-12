package com.example.challenge_literalura.DTO;

import com.example.challenge_literalura.models.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record livroDTO(@JsonAlias("title") String titulo,
                       @JsonAlias("languages") List<String> idiomas,
                       @JsonAlias("authors") List<autorDTO> autor,
                       @JsonAlias("download_count") Integer numeroDeDownloads) {
}
