package com.mjlf.MVC.dao.server;

import com.mjlf.MVC.Entity.User;
import com.mjlf.MVC.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by a123 on 17/6/15.
 */
@Service
public class UserServer {
    @Autowired
    private UserMapper userMapper;

    public User findName(String name){
        return userMapper.findName(name);
    }
}
