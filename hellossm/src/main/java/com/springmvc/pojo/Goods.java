package com.springmvc.pojo;

public class Goods {
    private int commId;
    private String commName;
    private int classifyId;
    private double commPrice;
    private int commStatus;

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

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public double getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(double commPrice) {
        this.commPrice = commPrice;
    }

    public int getCommStatus() {
        return commStatus;
    }

    public void setCommStatus(int commStatus) {
        this.commStatus = commStatus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "commId=" + commId +
                ", commName='" + commName + '\'' +
                ", classifyId=" + classifyId +
                ", commPrice=" + commPrice +
                ", commStatus=" + commStatus +
                '}';
    }
}
