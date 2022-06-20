package com.projects.productservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.productservice.Entity.Product;
import com.projects.productservice.Repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl  implements IProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        log.info("Product Service : Save Method");
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int productId) {
        log.info("Product Service : Getting Product with Id : "+ productId);
        return productRepository.getProductByproductId(productId);
    }

    public List<Product> getAllProducts() {
        log.info("Product Service : Getting All Products");
        return productRepository.findAll();
    }
    
}
