package ru.gb.mongo_example.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.mongo_example.dao.CartDao;
import ru.gb.mongo_example.entity.Cart;
import ru.gb.mongo_example.entity.CartProduct;
import ru.gb.mongo_example.entity.Product;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartDao cartDao;

    public Cart addProduct(Product product, String cartId){
        Cart cart = cartDao.findById(cartId).orElseThrow(() -> new RuntimeException("Нет такой корзины"));
        CartProduct cartProduct = cart.getCartProducts().stream().filter(item -> item.getProductId().equals(product.getId())).findFirst().orElse(null);
        if (cartProduct !=null){
            cartProduct.setCount(cartProduct.getCount()+1);
            cartProduct.setFullCost(cartProduct.getFullCost().add(cartProduct.getCost()));
        } else {
         cart.getCartProducts().add(new CartProduct(product));
        }
     return cartDao.save(cart);
    }

    public Cart deleteProduct(String cartId, String productId){
        Cart cart = cartDao.findById(cartId).orElseThrow(() -> new RuntimeException("Нет такой корзины"));
        CartProduct cartProductToDelete = cart.getCartProducts().stream().filter(item -> item.getProductId().equals(productId)).findFirst().orElse(null);
        if (cartProductToDelete !=null){
            if (cartProductToDelete.getCount() != 1) {
                cartProductToDelete.setCount(cartProductToDelete.getCount()-1);
                cartProductToDelete.setFullCost(cartProductToDelete.getFullCost().subtract(cartProductToDelete.getCost()));
            } else {
                cart.getCartProducts().remove(cartProductToDelete);
            }
        } else {
            throw new RuntimeException("Такого продукта в корзине нет");
        }
        return cartDao.save(cart);
    }

    public Cart showCart (String id){
        return cartDao.findById(id).orElseThrow(() -> new RuntimeException("Нет такой корзины"));
    }

    public Cart createCart (){
        return cartDao.save(new Cart(Collections.emptySet()));
    }

}
