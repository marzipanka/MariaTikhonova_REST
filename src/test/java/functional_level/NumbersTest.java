package functional_level;

import dto.SpellResultDto;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

import java.util.Arrays;

public class NumbersTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"12345", ""},
                {"helloo123", "hello 123"},
                {"123helloo", "123 hello"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkNumbersTextTest(String text, String expectedText) {

        SpellResultDto[] result = new SpellerSteps()
                .checkTextWithOptions(text, Arrays.asList(Options.IGNORE_DIGITS));

        if(expectedText.equals("")) {
            new SpellerAssertions(result)
                    .verifyEmptyResponse();
        }
        else {
            new SpellerAssertions(result)
                    .verifyText(expectedText);
        }
    }
}
