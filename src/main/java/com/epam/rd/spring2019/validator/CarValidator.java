package com.epam.rd.spring2019.validator;

import com.epam.rd.spring2019.web.dto.CarCreateDto;

public interface CarValidator {
    void validateNewCar(CarCreateDto carCreateDto);
}
