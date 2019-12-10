package com.zmx.jxauca.service.impl;

import com.zmx.jxauca.entity.User;
import com.zmx.jxauca.mapper.UserMapper;
import com.zmx.jxauca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean userLogin(String userName,String userPwd) {
        String findUserPwd = userMapper.selectPwd(userName);
        if(findUserPwd.equals(userPwd)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}
