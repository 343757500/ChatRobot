package com.chatRobot.dao;


import com.chatRobot.model.User;

public interface UserDao {
    User selectUser(long id);
}
