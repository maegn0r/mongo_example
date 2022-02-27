package ru.gb.mongo_example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.mongo_example.entity.Product;
import ru.gb.mongo_example.service.ProductService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> getAll (){
    return productService.getAll();
    }

    @PostMapping()
    public Product addNew (@RequestBody Product product){
        return productService.save(product);
    }
}
