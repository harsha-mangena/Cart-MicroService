package com.projects.cartservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    private Integer productId;

    private String productName;

    private Float productPrice;

    private String productManufactureDate;

}