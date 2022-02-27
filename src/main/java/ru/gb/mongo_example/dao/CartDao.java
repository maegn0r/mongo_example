package ru.gb.mongo_example.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.gb.mongo_example.entity.Cart;


public interface CartDao extends MongoRepository<Cart, String> {
}
