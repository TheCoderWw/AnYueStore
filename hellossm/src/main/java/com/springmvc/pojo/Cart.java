package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cart {
    private int userId;
//    private int commId;
//    private String commSize;
//    private String commColor;
//    private List<Integer> cartStatus;     //购物车中商品的状态
    private List<CartGoods> cartGoods;  //对商品一对多


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getCommId() {
//        return commId;
//    }
//
//    public void setCommId(int commId) {
//        this.commId = commId;
//    }
//
//    public String getCommSize() {
//        return commSize;
//    }
//
//    public void setCommSize(String commSize) {
//        this.commSize = commSize;
//    }

//    public String getCommColor() {
//        return commColor;
//    }
//
//    public void setCommColor(String commColor) {
//        this.commColor = commColor;
//    }
//
//    //
//    public List<Integer> getCartStatus() {
//        return cartStatus;
//    }
//
//    public void setCartStatus(List<Integer> cartStatus) {
//        this.cartStatus = cartStatus;
//    }


    public List<CartGoods> getCartGoods() {
        return cartGoods;
    }

    public void setCartGoods(List<CartGoods> cartGoods) {
        this.cartGoods = cartGoods;
    }


}
