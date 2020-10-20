package com.epam.task07.main.validator.line;

import org.junit.Assert;
import org.junit.Test;

public class RegExLineValidatorTest {

    private final static String VALID_LINE = "0.0 -1.0 0.0 5.0 4.0 0.0";
    private final static String INVALID_LINE = "0d.0 -1.0 0.0 5.0 4.0 0.0";

    public final RegExLineValidator validator = new RegExLineValidator();

    @Test
    public void testIsValidShouldReturnTrueWhenLineIsValid() {
        //when
        boolean actual = validator.isValid(VALID_LINE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenLineInvalid() {
        //when
        boolean actual = validator.isValid(INVALID_LINE);
        //then
        Assert.assertFalse(actual);
    }
}