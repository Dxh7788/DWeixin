package com.link.service.impl;

import com.link.db.UserMapper;
import com.link.data.entity.User;
import com.link.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/5 16:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public void createUser(User user) {
        userMapper.insert(user);
    }
}
