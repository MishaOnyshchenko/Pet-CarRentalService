package com.epam.rd.spring2019.service;


import com.epam.rd.spring2019.web.dto.UserCreateDto;
import com.epam.rd.spring2019.web.dto.UserViewDto;

public interface UserService {

    UserViewDto login(String email, String password);

    UserViewDto registerUser(UserCreateDto createDto);
}
