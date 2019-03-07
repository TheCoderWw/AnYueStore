package com.springmvc.contorller;

import com.springmvc.pojo.Cart;
import com.springmvc.pojo.CartGoods;
import com.springmvc.service.CartService;
import com.springmvc.util.TokenUserIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/cart")
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/addGoods")
    @ResponseBody
    public Map<String, Object> addGoods(@RequestBody CartGoods cartGoods, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        cartService.addGoods(TokenUserIdUtil.getLoginerId(request), cartGoods);
        map.put("status", 200);
        return map;

    }

    @RequestMapping(value = "/getAllGoods")
    @ResponseBody
    public Map<String, Object> getAllGoods(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("cart", cartService.getAllGoods(TokenUserIdUtil.getLoginerId(request)));
        return map;
    }

    @RequestMapping(value = "/deleteGoods")
    @ResponseBody
    public Map<String, Object> deleteAddress(@RequestBody Cart cart) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(cart);
        if (cartService.deleteGoods(cart.getCartGoods()) == cart.getCartGoods().size()) {
            map.put("status", 200);
        } else {
            map.put("status", 201);
        }
        return map;
    }
}
