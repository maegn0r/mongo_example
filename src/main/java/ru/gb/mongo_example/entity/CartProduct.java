package ru.gb.mongo_example.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartProduct{

    private String productId;
    private String name;
    private BigDecimal cost;
    private BigDecimal fullCost;
    private Integer count;


    public CartProduct(Product product){
        this.productId = product.getId();
        this.name = product.getName();
        this.cost = product.getCost();
        this.fullCost = product.getCost();
        this.count = 1;
    }
}
