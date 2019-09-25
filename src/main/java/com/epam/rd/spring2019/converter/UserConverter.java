package com.epam.rd.spring2019.converter;


import com.epam.rd.spring2019.entity.User;
import com.epam.rd.spring2019.web.dto.UserCreateDto;
import com.epam.rd.spring2019.web.dto.UserViewDto;

public class UserConverter {

    public UserViewDto toDto(User user) {
        UserViewDto dto = new UserViewDto();
        dto.setAge(user.getAge());
        dto.setId(user.getId());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }

    public User toUser(UserCreateDto createDto) {
        User user = new User();
        user.setEmail(createDto.getEmail());
        user.setPassword(createDto.getPassword());
        user.setName(createDto.getName());
        user.setSurname(createDto.getSurname());
        user.setAge(createDto.getAge());
        return user;
    }
}