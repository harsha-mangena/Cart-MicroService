package com.projects.cartservice.Entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Cart")
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @NonNull private String cartOwnerName;

    @NonNull private String cartOwnerNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "products", joinColumns = @JoinColumn(name = "cartId"))
    private List<Integer> productIds;
    
}
