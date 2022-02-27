package ru.gb.mongo_example.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Product {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal cost;
}
