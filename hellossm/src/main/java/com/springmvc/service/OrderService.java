package com.springmvc.service;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.Item;
import com.springmvc.pojo.Order;

import java.util.List;

public interface OrderService {
    int createOrder(Order order,int userId) throws MyException;

    void doInventory(Item item,String operate) throws MyException;
    List<Order> showAllOrderByUser(int userId);


    Order showOneOrder(int orderId);
//
//    int upOrderStatus(int status,int orderId);

    int paidStatus(int orderId,int addressId) throws MyException;

    int cancelStatus(int orderId) throws MyException;
}
