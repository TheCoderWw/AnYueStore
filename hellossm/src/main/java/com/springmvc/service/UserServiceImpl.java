package com.springmvc.service;

import com.springmvc.dao.MyException;
import com.springmvc.dao.UserMapper;
import com.springmvc.pojo.User;
import com.springmvc.util.EmailUtils;
import com.springmvc.util.MD5Utils;
import com.springmvc.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public User getUserById(int id) {
        return userMapper.findUserById(id);

    }

    @Override
    public int register(User user) throws MyException {
        isNameExist(user.getUserName());

        String uuid = UUIDUtils.getUUID();
        String email = user.getUserEmail();
        String password = user.getPassWord();
        user.setPassWord(MD5Utils.encryption(password));
        user.setUserRegistTime(new Timestamp(new Date().getTime()));

        user.setUserAuthCode(uuid);
        emailUtils.sendEmail(email, uuid);

        return userMapper.addUser(user);
    }

    @Override
    public User login(User user) throws MyException {
        User temUser = userMapper.findUserByName(user.getUserName());
        //判断是否存在,或者存在但用户密码不一致
        if (temUser == null || !temUser.getPassWord().equals(MD5Utils.encryption(user.getPassWord()))) {
            throw new MyException("用户名或密码错误");
            //验证用户密码和用户状态
        } else if (temUser.getUserStatus() != 0) {
            return temUser;
        }
        throw new MyException("该用户尚未激活,请激活成功后登录");
    }

    @Override
    public int verifyAuthCode(String authCode) throws MyException {
        int verify = 0;
        User u = userMapper.verifyAuthCode(authCode);
        if (u == null) {
            throw new MyException("激活失败,原因如下:1,激活码有误2,账号保留时间超出,请重新注册");
        } else {
            Integer userId = u.getId();
            Integer userStatus = u.getUserStatus();
            if (userId != null) {
                if (System.currentTimeMillis() - u.getUserRegistTime().getTime() - 1000 * 60 * 10 > 0) {
                    throw new MyException("已经超时,无法激活,请重新发送激活码");
                } else if (userStatus == 0) {
                    userMapper.upDateByUser(userId);
                    verify = 1;
                } else {
                    throw new MyException("已经激活过了,不能重复激活");
                }
            }
            return verify;
        }
    }

    @Override
    public int isNameExist(String userName) throws MyException {
        User temUser = userMapper.findUserByName(userName);
        if (temUser != null)
            throw new MyException("该用户名已存在!");
        return 0;
    }

    /**
     * 个人主页显示全部信息
     *
     * @param id
     * @return
     */
    @Override
    public User showAllInfo(int id) {
        User user = userMapper.findUserById(id);
        System.out.println(user);
        return user;
    }

    /**
     * 保存个人信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateAllInfo(User user) {
        return userMapper.updateAllInfo(user);
    }


}