package com.chatRobot.service.impl;

import com.chatRobot.dao.UserDao;
import com.chatRobot.model.User;
import com.chatRobot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }
}
