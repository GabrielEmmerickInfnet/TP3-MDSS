package com.infnet.fornecedor_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClimaService {

    private final WebClient webClient;

    // URL da API de Clima
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "API_KEY"; // chave da API

    public ClimaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(API_URL).build();
    }

    // Método para buscar clima por cidade
    public Mono<String> buscarClimaPorCidade(String cidade) {
        return this.webClient
            .get()
            .uri("?q={cidade}&appid={apiKey}&units=metric", cidade, API_KEY)
            .retrieve()
            .bodyToMono(String.class); 
    }
}
