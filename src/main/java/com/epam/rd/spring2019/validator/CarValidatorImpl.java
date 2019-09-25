package com.epam.rd.spring2019.validator;

import com.epam.rd.spring2019.exception.ValidationException;
import com.epam.rd.spring2019.web.dto.CarCreateDto;
import org.apache.commons.lang3.StringUtils;

public class CarValidatorImpl implements CarValidator {

    @Override
    public void validateNewCar(CarCreateDto carCreateDto) {
        if (StringUtils.isEmpty(carCreateDto.getBrand()) || StringUtils.isEmpty(carCreateDto.getName())
                || StringUtils.isEmpty(carCreateDto.getCategory()) || carCreateDto.getPrice() == null) {
            throw new ValidationException("Invalid data. Received empty field: " + carCreateDto.getName());
        }
    }
}
