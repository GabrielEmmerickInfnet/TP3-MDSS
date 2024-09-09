package com.infnet.fornecedor_service.controller;

import com.infnet.fornecedor_service.model.Produto;
import com.infnet.fornecedor_service.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Mono<Produto> criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public Flux<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @PutMapping("/{id}")
    public Mono<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> excluirProduto(@PathVariable Long id) {
        return produtoService.excluirProduto(id);
    }
}
