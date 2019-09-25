package com.epam.rd.spring2019.validator;


import com.epam.rd.spring2019.web.dto.UserCreateDto;

public interface UserValidator {

    void validateUserCredentials(String email, String password);

    void validateNewUser(UserCreateDto createDto);
}
