package functional_level;

import dto.SpellResultDto;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class CorrectTextTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"window"},
                {"forest"},
                {"Peter"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkCorrectTextTest(String text) {

        SpellResultDto[] result = new SpellerSteps()
                .checkTextWithoutOptions(text);

        new SpellerAssertions(result)
                .verifyEmptyResponse();
    }
}
