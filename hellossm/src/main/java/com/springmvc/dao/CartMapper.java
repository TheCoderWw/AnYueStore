package com.springmvc.dao;

import com.springmvc.pojo.Cart;
import com.springmvc.pojo.CartGoods;
import com.springmvc.pojo.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {
    void addGoods(@Param("userId") int userId, @Param("cartGoods") CartGoods cartGoods);

    int deleteGoods(List<CartGoods> cartGoodsList);

    int deleteItem(@Param("orderId") int orderId);
}
