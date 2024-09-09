package com.infnet.fornecedor_service.repository;

import com.infnet.fornecedor_service.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
}
