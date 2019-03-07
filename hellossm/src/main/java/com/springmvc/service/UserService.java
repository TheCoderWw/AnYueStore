package com.springmvc.service;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.User;

public interface UserService {
    User getUserById(int id);

    int register(User user) throws MyException;

    User login(User user) throws MyException;

    int verifyAuthCode(String authCode) throws MyException;

    int isNameExist(String userName) throws MyException;

    User showAllInfo(int id);

    int updateAllInfo(User user);
}
