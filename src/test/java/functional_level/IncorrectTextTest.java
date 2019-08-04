package functional_level;

import dto.SpellResultDto;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

import java.util.Arrays;

public class IncorrectTextTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"weendow", "window"},
                {"programmeer", "programmer"},
                {"catcat", "cat"},
                {"rusian", "russian"},
                {"AMERICCA", "AMERICA"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkIncorrectTextTest(String text, String expectedText) {

        SpellResultDto[] result = new SpellerSteps()
                .checkTextWithOptions(text, Arrays.asList(Options.IGNORE_CAPITALIZATION));

        new SpellerAssertions(result)
                .verifyText(expectedText);
    }
}
