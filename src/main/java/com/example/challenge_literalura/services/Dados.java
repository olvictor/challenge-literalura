package com.example.challenge_literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Dados {
    ObjectMapper mapper = new ObjectMapper();

    public JsonNode obterDados(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;
        try{
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();

            JsonNode jsonObject = mapper.readTree(json);
            JsonNode results = jsonObject.get("results");
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public <T> T converterDados(String Json, Class<T> Classe) throws JsonProcessingException {
        return mapper.readValue(Json, Classe);
    }
}
