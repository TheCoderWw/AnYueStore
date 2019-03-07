package com.springmvc.pojo;

public class SearchGoods extends Goods {
    private String pictureAddr;

    public String getPictureAddr() {
        return pictureAddr;
    }

    public void setPictureAddr(String pictureAddr) {
        this.pictureAddr = pictureAddr;
    }

    @Override
    public String toString() {
        return "SearchGoods{" +
                "pictureAddr='" + pictureAddr + '\'' +
                '}';
    }
}
