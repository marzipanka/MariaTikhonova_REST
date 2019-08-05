package functional_level;

import dto.SpellResultDto;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class OnlyNumbersTest {

    @Test
    public void checkNumbersTextTest() {

        SpellResultDto[] result = new SpellerSteps()
                .checkTextWithOptions("12345");

        new SpellerAssertions(result)
                .verifyEmptyResponse();
    }
}
