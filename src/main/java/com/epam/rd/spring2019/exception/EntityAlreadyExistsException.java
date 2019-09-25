package com.epam.rd.spring2019.exception;

public class EntityAlreadyExistsException extends ApplicationException {

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
