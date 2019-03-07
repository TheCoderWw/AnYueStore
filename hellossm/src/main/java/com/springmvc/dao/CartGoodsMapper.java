package com.springmvc.dao;

import com.springmvc.pojo.CartGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartGoodsMapper {
    List<CartGoods> getGoods(int userId);
}
