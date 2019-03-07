package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品
 */
@Component
public class Commodity extends Goods{
    private List<String> allSizeList;
    private List<Integer> inventoryList;
    private List<String> allPicAddress;
    private List<String> allPicColor;

    public List<String> getAllSizeList() {
        return allSizeList;
    }

    public void setAllSizeList(List<String> allSizeList) {
        this.allSizeList = allSizeList;
    }

    public List<Integer> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Integer> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<String> getAllPicAddress() {
        return allPicAddress;
    }

    public void setAllPicAddress(List<String> allPicAddress) {
        this.allPicAddress = allPicAddress;
    }

    public List<String> getAllPicColor() {
        return allPicColor;
    }

    public void setAllPicColor(List<String> allPicColor) {
        this.allPicColor = allPicColor;
    }

    //    @Override
//    public String toString() {
//        return "Commodity{" +
//                "commId=" + commId +
//                ", commName='" + commName + '\'' +
//                ", classifyId=" + classifyId +
//                ", commPrice=" + commPrice +
//                ", commStatus=" + commStatus +
//                ", allSizeList=" + allSizeList +
//                ", inventoryList=" + inventoryList +
//                ", allPicAddress=" + allPicAddress +
//                '}';
//    }


    @Override
    public String toString() {
        return "Commodity{" +
                "allSizeList=" + allSizeList +
                ", inventoryList=" + inventoryList +
                ", allPicAddress=" + allPicAddress +
                ", allPicColor=" + allPicColor +
                '}';
    }
}

