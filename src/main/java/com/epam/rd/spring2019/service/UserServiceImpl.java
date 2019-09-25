package com.epam.rd.spring2019.service;


import com.epam.rd.spring2019.converter.UserConverter;
import com.epam.rd.spring2019.dao.UserDao;
import com.epam.rd.spring2019.dao.UserDaoImpl;
import com.epam.rd.spring2019.entity.User;
import com.epam.rd.spring2019.exception.ValidationException;
import com.epam.rd.spring2019.validator.UserValidator;
import com.epam.rd.spring2019.validator.UserValidatorImpl;
import com.epam.rd.spring2019.web.dto.UserCreateDto;
import com.epam.rd.spring2019.web.dto.UserViewDto;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private UserValidator userValidator = new UserValidatorImpl();
    private UserConverter userConverter = new UserConverter();
    private SecurityService securityService = new SecurityServiceImpl();

    @Override
    public UserViewDto login(String email, String password) {
        userValidator.validateUserCredentials(email, password);
        User user = userDao.getByEmail(email);
        if (!securityService.isCorrectPassword(user, password)) {
            throw new ValidationException("Wrong password");
        }
        return userConverter.toDto(user);
    }

    @Override
    public UserViewDto registerUser(UserCreateDto userCreateDto) {
        userValidator.validateNewUser(userCreateDto);
        User user = userConverter.toUser(userCreateDto);
        user = userDao.create(user);
        return userConverter.toDto(user);
    }
}