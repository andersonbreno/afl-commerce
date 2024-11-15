package com.aflweb.aflcommerce.services;

import com.aflweb.aflcommerce.Dto.ProductDto;
import com.aflweb.aflcommerce.entities.Product;
import com.aflweb.aflcommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    // Como buscar no banco de dados?
    // Através do reposiroty -> Injeto o repository aqui e usa ele para conectar ao banco.

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){
        // Retorna Dto para o controller
        Product product = repository.findById(id).get();
        return new ProductDto(product);
    }
}
