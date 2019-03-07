package com.springmvc.pojo;

import org.springframework.stereotype.Component;

@Component
public class Item {
    private int id;
    private int commId;
    private String commName;
    private String commSize;
    private String commColor;
    private int orderId;
    private int itemNum;
    private double itemPrice;
    private String picAddress;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommId() {
        return commId;
    }

    public void setCommId(int commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommSize() {
        return commSize;
    }

    public void setCommSize(String commSize) {
        this.commSize = commSize;
    }

    public String getCommColor() {
        return commColor;
    }

    public void setCommColor(String commColor) {
        this.commColor = commColor;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", commId=" + commId +
                ", commName='" + commName + '\'' +
                ", commSize='" + commSize + '\'' +
                ", commColor='" + commColor + '\'' +
                ", orderId=" + orderId +
                ", itemNum=" + itemNum +
                ", itemPrice=" + itemPrice +
                ", picAddress='" + picAddress + '\'' +
                '}';
    }
}
