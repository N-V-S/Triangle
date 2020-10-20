package com.epam.task07.main.data;

import java.util.List;

public interface DataReader {

    List<String> readLines() throws DataException;
}