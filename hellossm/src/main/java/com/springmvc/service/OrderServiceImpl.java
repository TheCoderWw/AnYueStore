package com.springmvc.service;

import com.springmvc.dao.*;
import com.springmvc.pojo.Commodity;
import com.springmvc.pojo.Item;
import com.springmvc.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private TopMapper topMapper;
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private BottomMapper bottomMapper;

    @Autowired
    private Order order;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CartMapper cartMapper;

    @Transactional(rollbackFor = MyException.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public int createOrder(Order order, int userId) throws MyException {
        order.setUserId(userId);
        order.setOrderTime(new Timestamp(new Date().getTime()));
        orderMapper.insertOrder(order);
        if (orderMapper.insertItem(order.getItemList(), order.getId()) == order.getItemList().size()) {
            Iterator iterator = order.getItemList().iterator();
            while (iterator.hasNext()) {
                Item item = (Item) iterator.next();
                doInventory(item, "delete");
            }
        }
        return order.getId();

    }

    @Override
    @Transactional(propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED, rollbackFor = MyException.class)
    public void doInventory(Item item, String operate) throws MyException {
        Commodity commodity = commodityMapper.getCommById(item.getCommId());
        if ("delete".equals(operate)) {
            if (commodity.getClassifyId() == 3 || commodity.getClassifyId() == 5) {     //判断是否为上装

                if (topMapper.selectInven(item.getCommId(), item.getCommSize()) - item.getItemNum() < 0)
                    throw new MyException("抱歉,您所购买的物品库存不足");

                topMapper.deleteInven(item.getCommId(), item.getCommSize(), item.getItemNum());
            } else {
                if (bottomMapper.selectInven(item.getCommId(), item.getCommSize()) - item.getItemNum() < 0)
                    throw new MyException("抱歉,您所购买的物品库存不足");

                bottomMapper.deleteInven(item.getCommId(), item.getCommSize(), item.getItemNum());
            }
        } else {
            if (commodity.getClassifyId() == 3 || commodity.getClassifyId() == 5) {
                topMapper.addInven(item.getCommId(), item.getCommSize(), item.getItemNum());
            } else {
                bottomMapper.addInven(item.getCommId(), item.getCommSize(), item.getItemNum());
            }
        }
    }

    @Override
    public List<Order> showAllOrderByUser(int userId) {
        List<Order> orders = orderMapper.selectOrderBase(userId);
        Iterator iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = (Order) iterator.next();
            order.setItemList(orderMapper.selectAllOrderByUser(order.getId()));
        }
        return orders;
    }

    @Override
    public Order showOneOrder(int orderId) {
        order = orderMapper.selectOrderOne(orderId);
        order.setItemList(orderMapper.selectAllOrderByUser(orderId));
        order.setAddress(addressMapper.selectAddressById(order.getAddrId()));
        return order;
    }

//    @Override
//    public int upOrderStatus(int status, int orderId) {
//        return orderMapper.upOrderStatus(status, orderId);
//    }

    /**
     * *付款成功修改订单状态
     *
     * @param orderId
     * @return
     */
    @Override
    public int paidStatus(int orderId,int addressId) throws MyException {
        int temStatus = orderMapper.selectStatusById(orderId);
        if (temStatus == 2)
            throw new MyException("该订单已完成支付,请勿重复操作");
        else if (temStatus == 0)
            throw new MyException("该订单已取消");
        orderMapper.updateOrderAddr(addressId,orderId);
        cartMapper.deleteItem(orderId);
        return orderMapper.upOrderStatus(2, orderId);
    }

    @Override
    public int cancelStatus(int orderId) throws MyException {
        int temStatus = orderMapper.selectStatusById(orderId);
        if (temStatus == 2)
            throw new MyException("该订单已完成支付,无法取消");
        else if (temStatus == 0)
            throw new MyException("该订单已取消,请勿重复操作");
        Iterator<Item> itemIterator = orderMapper.selectAllOrderById(orderId).iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            doInventory(item, "add");
        }
        return orderMapper.upOrderStatus(0, orderId);
    }


}
