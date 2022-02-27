package ru.gb.mongo_example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.mongo_example.dao.ProductDao;
import ru.gb.mongo_example.entity.Product;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public List<Product> getAll (){
        return productDao.findAll();
    }

    public Product findById (String id){
        return productDao.findById(id).orElseThrow(() -> new RuntimeException("Нет такого продукта"));
    }

    public Product save (Product product){
        return productDao.save(product);
    }
}
