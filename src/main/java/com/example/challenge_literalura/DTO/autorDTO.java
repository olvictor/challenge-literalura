package com.example.challenge_literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record autorDTO(@JsonAlias("name")String nome,
                       @JsonAlias("birth_year") Integer dataNascimento,
                       @JsonAlias("death_year") Integer dataFalecimento) {


    public String getNome() {
        return nome;
    }

    public Integer getAnoNascimento() {
        return dataNascimento;
    }

    public Integer getAnoMorte() {
        return dataFalecimento;
    }

    public Integer getAnoDeNascimento() {
        return dataNascimento;
    }

    public Integer getAnoDeFalecimento() {
        return dataFalecimento;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataFalecimento=" + dataFalecimento;
    }
}
