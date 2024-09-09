package com.infnet.fornecedor_service.controller;

import com.infnet.fornecedor_service.model.Fornecedor;
import com.infnet.fornecedor_service.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.criarFornecedor(fornecedor);
    }

    @GetMapping
    public Iterable<Fornecedor> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

    @PutMapping("/{id}")
    public Fornecedor atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.atualizarFornecedor(id, fornecedor);
    }

    @DeleteMapping("/{id}")
    public void excluirFornecedor(@PathVariable Long id) {
        fornecedorService.excluirFornecedor(id);
    }
}
