package ru.gb.mongo_example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.mongo_example.entity.Cart;
import ru.gb.mongo_example.entity.Product;
import ru.gb.mongo_example.service.CartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/{id}")
    public Cart fingById(@PathVariable String id){
        return cartService.showCart(id);
    }

    @GetMapping("/new")
    public Cart createCart(){
        return cartService.createCart();
    }

    @PostMapping("/add/{id}")
    public  Cart addToCart(@PathVariable String id, @RequestBody Product product){
        return cartService.addProduct(product, id);
    }

    @GetMapping("/remove/{cartId}")
    public  Cart removeFromCart(@PathVariable String cartId, @RequestParam String productId){
        return cartService.deleteProduct(cartId,productId);
    }
}
