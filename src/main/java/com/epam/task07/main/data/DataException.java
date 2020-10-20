package com.epam.task07.main.data;

public class DataException extends Exception {

    public DataException(String message, Exception e) {
        super(message, e);
    }
}