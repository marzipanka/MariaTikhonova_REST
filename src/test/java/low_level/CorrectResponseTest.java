package low_level;

import org.testng.annotations.Test;
import service.SpellerService;
import service.URI;

public class CorrectResponseTest {

    @Test
    public void checkResponseTest() {

        new SpellerService().getNoParams(URI.GET_CORRECT_TEXT, "helloo")
                .then().statusCode(200);
    }
}
