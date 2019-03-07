package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class Order {
    private int id;
    private int userId; //通过token拦截器获取
//    private String orderNum;    //生成
    private Date orderTime;     //now
    private int orderStatus;
    private int addrId;
    private Address address;

    private List<Item> itemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public String getOrderNum() {
//        return orderNum;
//    }
//
//    public void setOrderNum(String orderNum) {
//        this.orderNum = orderNum;
//    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderTime=" + orderTime +
                ", orderStatus=" + orderStatus +
                ", addrId=" + addrId +
                ", address=" + address +
                ", itemList=" + itemList +
                '}';
    }
}
