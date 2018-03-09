package com.base.service;

import com.base.dao.UserMapper;
import com.base.dao.pojo.User;
import com.base.daoEx.UserExMapper;
import com.base.daoEx.pojo.UserEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserExMapper userExMapper;

    public UserEx getUserByUser(User user){

        return userExMapper.selectUserExByUser(user);
    }
}
