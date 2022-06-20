package com.projects.cartservice.Service;

import com.projects.cartservice.Entity.Cart;
import com.projects.cartservice.VO.ResponseTemplate;

public interface ICartService {
    
    /**
     * Method :Getting a new Cart
     * @param : Cart [OwnerName, OwnerNumber]
     * @return : new Cart 
     */
    public Cart getNewCart(Cart cart);

    /**
     * Method : Getting cart by Id
     * @param : CartId
     * @return : Cart<Object>
     */
    public ResponseTemplate getCartByIdWithProduct(Integer cartId);
}
