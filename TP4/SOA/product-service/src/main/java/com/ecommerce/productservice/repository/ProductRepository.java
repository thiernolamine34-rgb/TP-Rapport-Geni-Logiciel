package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Grâce à JpaRepository, les méthodes findAll(), findById(), save(), etc. 
    // sont déjà prêtes à l'emploi sans écrire de code !
}