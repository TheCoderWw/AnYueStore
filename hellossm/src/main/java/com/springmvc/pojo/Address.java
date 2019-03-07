package com.springmvc.pojo;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private int id;
    private int userId;
    private String addrName;
    private String cnee;    //收货人
    private String addrPhone;

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

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getCnee() {
        return cnee;
    }

    public void setCnee(String cnee) {
        this.cnee = cnee;
    }

    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone;
    }
}
