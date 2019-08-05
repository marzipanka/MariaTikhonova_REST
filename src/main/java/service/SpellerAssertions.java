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
        List resultList = Arrays.asList(result);
        assertTrue(resultList.isEmpty());
    }

    //fixed todo про название - написала коменты ниже
    public SpellerAssertions verifyCorrectText(String expectedText) {
        assertTrue(result[0].getS().contains(expectedText));
        return this;
    }
}
