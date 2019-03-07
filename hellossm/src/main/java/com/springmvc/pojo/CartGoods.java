package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartGoods extends SearchGoods {
    private String goodsSize;
    private String goodsColor;
    private int goodsSum;
    private int goodsAllMoney;
    private int cartId;
    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public int getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(int goodsSum) {
        this.goodsSum = goodsSum;
    }

    public int getGoodsAllMoney() {
        return (int) (goodsSum*super.getCommPrice());
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartGoods{" +
                "goodsSize='" + goodsSize + '\'' +
                ", goodsColor='" + goodsColor + '\'' +
                ", goodsSum=" + goodsSum +
                ", goodsAllMoney=" + goodsAllMoney +
                ", cartId=" + cartId +
                '}';
    }
}
