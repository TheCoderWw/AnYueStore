package com.springmvc.service;

import com.springmvc.dao.CartGoodsMapper;
import com.springmvc.dao.CartMapper;
import com.springmvc.pojo.Cart;
import com.springmvc.pojo.CartGoods;
import com.springmvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartGoodsMapper cartGoodsMapper;

    @Autowired
    private Cart cart;

    @Override
    public void addGoods(int userId, CartGoods cartGoods) {
        cartMapper.addGoods(userId, cartGoods);
    }

    @Override
    public Cart getAllGoods(int userId) {
        List<CartGoods> list = cartGoodsMapper.getGoods(userId);
        cart.setCartGoods(list);
        cart.setUserId(userId);

        return cart;
    }

//    @Override
//    public int deleteGoods(Cart cart) {
//        return 0;
//    }

    @Override
    public int deleteGoods(List<CartGoods> cartGoodsList) {
        return cartMapper.deleteGoods(cartGoodsList);
    }


}
