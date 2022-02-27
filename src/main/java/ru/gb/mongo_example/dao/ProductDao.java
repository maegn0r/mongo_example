package ru.gb.mongo_example.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.gb.mongo_example.entity.Product;

public interface ProductDao extends MongoRepository<Product, String> {
}
