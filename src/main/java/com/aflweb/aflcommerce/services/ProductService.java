package com.aflweb.aflcommerce.services;

import com.aflweb.aflcommerce.Dto.ProductDto;
import com.aflweb.aflcommerce.entities.Product;
import com.aflweb.aflcommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable){
        // Retorna Dto para o controller
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDto(x));
    }

    @Transactional
    public ProductDto insert(ProductDto dto){
        // Copiar pra essa entity os dados que vieram no Dto
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);

        return new ProductDto(entity);
    }
}
