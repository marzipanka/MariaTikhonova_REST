package functional_level;

import dto.SpellResultDto;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class NumbersWithTextTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"helloo123", "hello 123"},
                {"123helloo", "123 hello"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkNumbersTextTest(String text, String expectedText) {

        SpellResultDto[] result = new SpellerSteps()
                .checkTextWithOptions(text, Options.IGNORE_DIGITS);

        //fixed todo писать if/for/case и другие сложные конструкции в тесте уменьшаю читабельность теста.
        //одно из правил - тест должен быть читабельным, а второй - повторяемый.Если есть условный опреатор, то
        // о какой воспроизводимости может ижти речь? :)

        //Я использовала if, потому что в дата провайдере у меня был текст "12345", и для него я не могла
        //использовать метод verifyCorrectText, потому что метод возвращал бы NullPointerException, т.к.
        //на запросы, состоящие только из цифр, Яндекс Спеллер отвечает пустым респонсом. И я не знала, как бы
        //можно было это обойти без помощи if или case.
        //В общем, я вынесла тест с этим текстом "12345" в класс OnlyNumbersTest

            new SpellerAssertions(result)
                    .verifyCorrectText(expectedText);
    }
}
