package com.projects.productservice.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.projects.productservice.Entity.Product;
import com.projects.productservice.Repository.ProductRepository;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class productServcieTest {

    @Autowired
    private ProductServiceImpl productService;

    @MockBean
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;

    @BeforeAll()
    void setUp()
    {

    }

    @BeforeEach()
    void setUp_MockProducts()
    {
        product1 = Product.builder()
                        .productId(123)
                        .productName("MediMex")
                        .productPrice((float)180)
                        .productManufactureDate("13-08-2021")
                        .build();

        product2 = Product.builder()
                        .productId(1577)
                        .productName("KS Deo Monn Light")
                        .productPrice((float)225)
                        .productManufactureDate("31-10-2021")
                        .build();
    }


    /**
     * Test For Adding Product
     */
    @Test
    void testFor_AddingProduct()
    {
        
        /**
         * When we call the saveProduct() in productService, It'll call save(Object) from JPA with productRepository Interface.
         * So we will mock the save() call from the saveProduct()  
         */
        when(productRepository.save(product1)).thenReturn(product1);

        assertEquals(product1.getProductId(),  productService.saveProduct(product1).getProductId());
                                        
    }


    /**
     * Test for Getting List of Products
     */
    @Test
    void testFor_GettingListOfProduct()
    {
        /**
         * When we call the getAllProducts() in productService, It'll call findAll(Object) from JPA with productRepository Interface.
         */
        List<Product> allProducts = new ArrayList<Product>();

        allProducts.add(product1);
        allProducts.add(product2);

        when(productRepository.findAll()).thenReturn(allProducts);

        assertEquals(allProducts.size(), 2);
    }

    /**
     * Test for Getting a Product By Id
     */
    @Test
    void testFor_GettingProductById()
    {
        when(productRepository.getProductByproductId(1)).thenReturn(product1);

        assertEquals(123, productService.getProductById(1).getProductId());
    }

}
