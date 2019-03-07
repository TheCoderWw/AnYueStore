package com.springmvc.dao;

import com.springmvc.pojo.User;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User findUserById(int id);

    int addUser(User user);

    User findUserByName(String username);

    User verifyAuthCode(String authCode);

    void upDateByUser(int statusCode);

    int updateAllInfo(User user);
}
