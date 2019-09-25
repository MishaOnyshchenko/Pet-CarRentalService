package com.epam.rd.spring2019.dao;


import com.epam.rd.spring2019.entity.User;

public interface UserDao {

    User getByEmail(String email);
    User create(User user);
}
