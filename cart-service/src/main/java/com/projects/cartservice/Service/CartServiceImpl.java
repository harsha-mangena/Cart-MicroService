package com.projects.cartservice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projects.cartservice.Entity.Cart;
import com.projects.cartservice.Repository.CartRepository;
import com.projects.cartservice.VO.Product;
import com.projects.cartservice.VO.ResponseTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    private List<Product> cartItems;

    @Override
    public Cart getNewCart(Cart cart) {
        log.info("Cart Service : Getting new cart");
        return cartRepository.save(cart);
    }

    @Override
    public ResponseTemplate getCartByIdWithProduct(Integer cartId) {
        log.info("Cart Service : Getting Cart with Id : "+cartId);

        //Return Object
        ResponseTemplate returnTemplate = new ResponseTemplate();

        Cart currentCart = cartRepository.getCartBycartId(cartId);
        List<Integer> Products = currentCart.getProductIds();
        List<Product> cartProducts = new ArrayList<Product>();

        for(Integer productId : Products){
            Product product = restTemplate.getForObject("http://PRODUCT-CATALOGUE/product/"+productId,Product.class);
            cartProducts.add(product);
        }

        cartItems = cartProducts;
        returnTemplate.setCart(currentCart);
        returnTemplate.setProductDetails(cartProducts);
        return returnTemplate;
    }

    public Cart addProductIntoCart(Integer cartId, Integer productId) {
        Cart cart = cartRepository.getCartBycartId(cartId);
        List<Integer> newProducts = cart.getProductIds();

        log.info("Cart Service : Getting Cart with Id :"+cartId);
        newProducts.add(productId);

        log.info("Added new Products to List and saving Cart");
        return cartRepository.save(cart);   
    }

    @Override
    public Float getBillAoumt(Integer cartId) {
        Float bill = (float)0;
        for(Product item : cartItems){
            bill += item.getProductPrice();
        }
        return bill;
    }
    
}
