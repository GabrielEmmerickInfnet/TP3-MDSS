package com.infnet.fornecedor_service.service;

import com.infnet.fornecedor_service.model.Fornecedor;
import com.infnet.fornecedor_service.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Iterable<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedorAtualizado) {
        return fornecedorRepository.findById(id)
            .map(f -> {
                f.setNome(fornecedorAtualizado.getNome());
                f.setCnpj(fornecedorAtualizado.getCnpj());
                f.setEndereco(fornecedorAtualizado.getEndereco());
                return fornecedorRepository.save(f);
            }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
