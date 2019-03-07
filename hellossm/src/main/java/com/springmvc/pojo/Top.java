package com.springmvc.pojo;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Top extends Commodity {
    private List<String> sizeList;
    private List<Integer> inventoryList;
    public List<String> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<String> sizeList) {
        this.sizeList = sizeList;
    }

    public List<Integer> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Integer> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
