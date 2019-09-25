package com.epam.rd.spring2019.validator;


import com.epam.rd.spring2019.dao.UserDaoImpl;
import com.epam.rd.spring2019.exception.EntityAlreadyExistsException;
import com.epam.rd.spring2019.exception.ValidationException;
import com.epam.rd.spring2019.web.dto.UserCreateDto;
import org.apache.commons.lang3.StringUtils;

public class UserValidatorImpl implements UserValidator {

    @Override
    public void validateUserCredentials(String email, String password) {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new ValidationException("Invalid credentials: " + email);
        }
    }

    @Override
    public void validateNewUser(UserCreateDto userCreateDto) {
        validateUserCredentials(userCreateDto.getEmail(), userCreateDto.getPassword());
        if (StringUtils.isEmpty(userCreateDto.getName())) {
            throw new ValidationException("Invalid user name: " + userCreateDto.getName());
        } else if (new UserDaoImpl().checkUserIfExists(userCreateDto.getEmail())) {
            throw new EntityAlreadyExistsException("Duplicated email: " + userCreateDto.getEmail());
        }
    }
}