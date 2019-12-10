package com.zmx.jxauca.mapper;

import com.zmx.jxauca.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public String selectPwd(String userName);
    public List<User> selectAll();

}
