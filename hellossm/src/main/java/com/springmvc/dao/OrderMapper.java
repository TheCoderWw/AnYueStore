package com.springmvc.dao;

import com.springmvc.pojo.Item;
import com.springmvc.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface OrderMapper {
    int insertOrder(Order order);

    int insertItem(@Param("list") List<Item> list, @Param("orderId") int orderId);

    List<Item> selectAllOrderByUser(@Param("list") int list);

    List<Order> selectOrderBase(@Param("userId") int userId);

    Order selectOrderOne(@Param("orderId") int orderId);

    int upOrderStatus(@Param("status") int status, @Param("orderId") int orderId);

    int selectStatusById(@Param("orderId") int orderId);

    void updateOrderAddr(@Param("addressId") int addressId,@Param("orderId") int orderId);

    List<Item> selectAllOrderById(@Param("orderId") int orderId);
}
