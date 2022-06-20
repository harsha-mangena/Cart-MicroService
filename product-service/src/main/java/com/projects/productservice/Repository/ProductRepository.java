package com.projects.productservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.productservice.Entity.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

    Product getProductByproductId(Integer productId);
    
}