package com.projects.cartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.cartservice.Entity.Cart;
import com.projects.cartservice.Service.CartServiceImpl;
import com.projects.cartservice.VO.ResponseTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {
    
    @Autowired
    private CartServiceImpl cartService;

    /**
     * API : /
     * @Param: Cart[OwnerName, OwnerNumber]
     * @return : Cart <Object> 
     */
    @PostMapping("/")
    public Cart getNewCart(@RequestBody Cart cart) {
        log.info("Cart Controller : Getting new Cart ready for user!");
        return cartService.getNewCart(cart);
    }

    /**
     * API : /{cartId}
     * @Param: cartId <Integer>
     * @return : Cart
     */
    @GetMapping("/{cartId}")
    public ResponseTemplate getCartbyId(@PathVariable Integer cartId){
        log.info("Cart Controller : Getting cart with id " + cartId);
        return cartService.getCartByIdWithProduct(cartId);
    }

    /**
     * API : /add/{productId}
     * @Param : productId
     * @Return : Cart<Object>
     */
    @PostMapping("/{cartId}/add/{productId}")
    public Cart addProduct(@PathVariable Integer cartId, @PathVariable Integer productId){
        log.info("Cart Controller : Adding Product into Cart");
        return cartService.addProductIntoCart(cartId, productId); 
    }

    /**
     * API : /bill/{cartId}
     * @Param :  cartId <Integer>
     * @return : Integer Bill Amount
     */
    @GetMapping("/bill/{cartId}")
    public Float getBillAmount(@PathVariable Integer cartId) {
        return cartService.getBillAoumt(cartId);
    }
    
}
