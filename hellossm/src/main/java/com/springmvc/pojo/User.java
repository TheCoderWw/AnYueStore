package com.springmvc.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class User {

    private int id;
    private String userName;
    private String passWord;
    private String userEmail;
    private int userAge;
    private String userSex;
    private int userStatus;
    private Date userRegistTime;
    private String userPhone;
    private int userMoney;
    private List<Address> addressList;  //收货信息按一对多
    private Cart cart;      //购物车一对一
    private List<Order> orderList;  //订单信息一对多
    private String userAuthCode;    //邮箱验证码

    public User(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserRegistTime() {
        return userRegistTime;
    }

    public void setUserRegistTime(Date userRegistTime) {
        this.userRegistTime = userRegistTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getUserAuthCode() {
        return userAuthCode;
    }

    public void setUserAuthCode(String userAuthCode) {
        this.userAuthCode = userAuthCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                ", userStatus=" + userStatus +
                ", userRegistTime=" + userRegistTime +
                ", userPhone='" + userPhone + '\'' +
                ", userMoney=" + userMoney +
                ", addressList=" + addressList +
                ", cart=" + cart +
                ", orderList=" + orderList +
                ", userAuthCode='" + userAuthCode + '\'' +
                '}';
    }
}
