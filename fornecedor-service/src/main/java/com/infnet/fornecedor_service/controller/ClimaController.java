package com.infnet.fornecedor_service.controller;

import com.infnet.fornecedor_service.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    // Endpoint para buscar clima por cidade
    @GetMapping("/{cidade}")
    public Mono<String> obterClimaPorCidade(@PathVariable String cidade) {
        return climaService.buscarClimaPorCidade(cidade);
    }
}
