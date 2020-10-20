package com.epam.task07.main.data;

import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileDataReaderTest {

    private static final String INPUT_FILE = "src/test/resources/input.txt";
    private static final String INVALID_FILE = "src/test/resources/invalid.txt";

    private static final String CHARACTER_ENCODING = "UTF-8";

    @Test
    public void testReadLinesShouldReturnStringListWhenFileExists() throws DataException, IOException {
        //given
        FileDataReader reader = new FileDataReader(INPUT_FILE);
        List<String> expected = FileUtils.readLines(new File(INPUT_FILE), CHARACTER_ENCODING);
        //when
        List<String> actual= reader.readLines();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class) //then
    public void testReadShouldThrowExceptionWhenFileNotExists() throws DataException {
        //given
        FileDataReader acquirer = new FileDataReader(INVALID_FILE);
        //when
        acquirer.readLines();
    }
}