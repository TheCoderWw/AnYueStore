package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bottom extends Commodity {
    private List<String> waistLineList;
    private List<Integer> inventoryList;

    public List<Integer> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Integer> inventoryList) {
        this.inventoryList = inventoryList;
    }
//    public String getWaisLine() {
//        return waisLine;
//    }

//    public void setWaisLine(String waisLine) {
//        this.waisLine = waisLine;
//    }
//
//
//    public List<String> getWaisLine() {
//        return waisLine;
//    }
//
//    public void setWaisLine(List<String> waisLine) {
//        this.waisLine = waisLine;
//    }

    public List<String> getWaistLineList() {
        return waistLineList;
    }

    public void setWaistLineList(List<String> waistLineList) {
        this.waistLineList = waistLineList;
    }
}
