package com.aflweb.aflcommerce.repositories;

import com.aflweb.aflcommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
