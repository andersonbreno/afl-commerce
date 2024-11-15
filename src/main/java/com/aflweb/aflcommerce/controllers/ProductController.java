package com.aflweb.aflcommerce.controllers;

import com.aflweb.aflcommerce.Dto.ProductDto;
import com.aflweb.aflcommerce.entities.Product;
import com.aflweb.aflcommerce.repositories.ProductRepository;
import com.aflweb.aflcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id){
        return service.findById(id);
    }
}
