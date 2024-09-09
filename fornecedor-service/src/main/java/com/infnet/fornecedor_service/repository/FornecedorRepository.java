package com.infnet.fornecedor_service.repository;

import com.infnet.fornecedor_service.model.Fornecedor;
import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {
    
}
