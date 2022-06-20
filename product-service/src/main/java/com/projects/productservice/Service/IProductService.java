package com.projects.productservice.Service;

import java.util.List;

import com.projects.productservice.Entity.Product;

public interface IProductService {
    /**
     * Method : Save
     * @return : Product <Object>
     * @param : Product <Obejct>
     */
    public Product saveProduct(Product product);

    /**
     * Method : Get Product By Id
     * @return : Product <Object>
     * @param : Integer product Id
     */
    public Product getProductById(int productId);

    /**
     * Method : Get All Products
     * @return : List<Product>
     */
    public List<Product> getAllProducts();
}
