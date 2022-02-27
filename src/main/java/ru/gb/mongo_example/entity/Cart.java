package ru.gb.mongo_example.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Cart {

    @Id
    private String id;
    private Set<CartProduct> cartProducts;

    public Cart(Set<CartProduct> cartProducts){
        this.cartProducts = cartProducts;
    }
}
