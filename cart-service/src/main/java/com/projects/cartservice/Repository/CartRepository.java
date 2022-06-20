package com.projects.cartservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.cartservice.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

    Cart getCartBycartId(Integer cartId);
    
}
