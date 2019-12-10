package com.zmx.jxauca.service;

import com.zmx.jxauca.entity.User;

import java.util.List;

public interface UserService {

    public boolean userLogin(String userName,String userPwd);
    public List<User> selectAll();
}
