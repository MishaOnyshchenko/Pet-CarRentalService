package com.epam.rd.spring2019.exception;

public class NoSuchEntityException extends ApplicationException{

    public NoSuchEntityException(String message) {
        super(message);
    }
}
