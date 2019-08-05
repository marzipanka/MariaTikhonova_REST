package functional_level;

import dto.SpellResultDto;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class EmptyStringTest {

    @Test
    public void checkEmptyStringTest() {

        SpellResultDto[] result = new SpellerSteps()
                .checkTextWithoutOptions("");

        //todo вот тут понятно, что присходит, в отличаи от verifyText
        new SpellerAssertions(result)
                .verifyEmptyResponse();
    }
}
