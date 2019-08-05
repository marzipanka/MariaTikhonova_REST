package functional_level;

import dto.SpellResultDto;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

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
                .checkTextWithOptions(text, Options.IGNORE_CAPITALIZATION);

        //fixed todo verifyText очень абстрактное название методу - не говорит о многом. Переименуй так, чтобы было понятни
        //, что конкретно происходит. Коротко, но звучно!
        new SpellerAssertions(result)
                .verifyCorrectText(expectedText);
    }
}
