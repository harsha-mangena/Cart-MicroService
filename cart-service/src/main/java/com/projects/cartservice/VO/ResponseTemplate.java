package com.projects.cartservice.VO;

import java.util.List;

import com.projects.cartservice.Entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Cart cart;
    private List<Product> productDetails;
}
