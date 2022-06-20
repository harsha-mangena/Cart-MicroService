package com.projects.productservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.productservice.Entity.Product;
import com.projects.productservice.Service.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    
    /**
     * API : /add
     * @param : Product <Object>
     * @response : 200, Product
     */
    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product) {
        log.info("Product Controller : Save Method");
        return productService.saveProduct(product);
    }

    /**
     * API : /{id}
     * @param : Integer productId
     * @return : Product <Object> 
     */
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        log.info("Product Controller : getProductById Method");
        return productService.getProductById(productId);
    }

    /*
     * API : /all
     * @param : None
     * @return : List of Product
     */
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        log.info("Product Controller : Inside getAllProducts Method");
        return productService.getAllProducts();
    }
    
}
