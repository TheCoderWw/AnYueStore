package com.springmvc.contorller;


import com.springmvc.dao.MyException;
import com.springmvc.pojo.Order;
import com.springmvc.service.OrderService;
import com.springmvc.util.TokenUserIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/createOrder")
    @ResponseBody
    public Map<String, Object> createOrder(@RequestBody Order order, HttpServletRequest request) {
        System.out.println(order);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("orderId", orderService.createOrder(order, TokenUserIdUtil.getLoginerId(request)));
            map.put("status", 200);
        } catch (MyException e) {
            map.put("status", 201);
            map.put("message", e.getMessage());
        }

        return map;

    }

    @RequestMapping(value = "/showOrder")
    @ResponseBody
    public Map<String, Object> showOrder(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("orderList", orderService.showAllOrderByUser(TokenUserIdUtil.getLoginerId(request)));
        return map;
    }

    @CrossOrigin
    @RequestMapping(value = "/showOneOrder")
    @ResponseBody
    public Map<String, Object> showOneOrder(@RequestParam("orderId") int orderId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("order", orderService.showOneOrder(orderId));
        return map;
    }

    @RequestMapping(value = "/paidOrder")
    @ResponseBody
    public Map<String, Object> paidOrder(@RequestParam("orderId") int orderId, @RequestParam("addressId") int addressId) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (orderService.paidStatus(orderId, addressId) == 1) {
                map.put("status", 200);
            }
        } catch (MyException e) {
            map.put("status", 201);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/cancelOrder")
    @ResponseBody
    public Map<String, Object> cancelOrder(@RequestParam("orderId") int orderId) {
        Map<String, Object> map = new HashMap<>();
        try {
            orderService.cancelStatus(orderId);
            map.put("status", 200);

        } catch (MyException e) {
            map.put("status", 201);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
