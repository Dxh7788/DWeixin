package com.link.db;

import com.link.entity.User;

import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/5 16:55
 */
public interface UserMapper {
    List<User> findAll();
    User findOne(Long id);
    void insert(User user);
}
