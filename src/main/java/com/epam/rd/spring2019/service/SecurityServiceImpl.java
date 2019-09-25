package com.epam.rd.spring2019.service;


import com.epam.rd.spring2019.entity.User;

public class SecurityServiceImpl implements SecurityService {

    @Override
    public boolean isCorrectPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}
