package com.infnet.fornecedor_service.service;

import com.infnet.fornecedor_service.model.Produto;
import com.infnet.fornecedor_service.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para criar um produto
    public Mono<Produto> criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Método para listar todos os produtos
    public Flux<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // Método para atualizar um produto
    public Mono<Produto> atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
            .flatMap(produtoExistente -> {
                produtoExistente.setNome(produtoAtualizado.getNome());
                produtoExistente.setPreco(produtoAtualizado.getPreco());
                return produtoRepository.save(produtoExistente);
            });
    }

    // Método para excluir um produto
    public Mono<Void> excluirProduto(Long id) {
        return produtoRepository.deleteById(id);
    }
}
