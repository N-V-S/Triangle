package com.epam.task07.main.idgenerator;

public class IdGeneratorImpl implements IdGenerator {

    private int id = 0;

    @Override
    public int getId() {
        return id++;
    }
}