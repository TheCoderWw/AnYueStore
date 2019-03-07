package com.springmvc.service;

import com.springmvc.pojo.Cart;
import com.springmvc.pojo.CartGoods;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
    void addGoods(int userId, CartGoods cartGoods);

    Cart getAllGoods(int userId);
    int deleteGoods(List<CartGoods> cartGoodsList);
}
