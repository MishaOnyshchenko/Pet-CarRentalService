package com.epam.rd.spring2019.service;


import com.epam.rd.spring2019.entity.User;

public interface SecurityService {

    boolean isCorrectPassword(User user, String password);
}
