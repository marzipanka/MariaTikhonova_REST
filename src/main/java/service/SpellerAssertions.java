package service;

import dto.SpellResultDto;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class SpellerAssertions {

    private SpellResultDto[] result;

    public SpellerAssertions(SpellResultDto[] result) {
        this.result = result;
    }

    public void verifyEmptyResponse() {
       // assertFalse(result.toString().contains("{"));

        List resultList = Arrays.asList(result);
        assertTrue(resultList.isEmpty());
    }

    public SpellerAssertions verifyText(String expectedText) {
        assertTrue(result[0].getS().contains(expectedText));
        return this;
    }
}
