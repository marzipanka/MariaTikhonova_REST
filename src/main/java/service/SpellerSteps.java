package service;

import com.google.gson.Gson;
import dto.SpellResultDto;
import enums.Options;

public class SpellerSteps {

    //Methods for "checkText" YandexSpeller method

    public SpellResultDto[] checkTextWithoutOptions(String text) {
        return checkText(text, Options.DEFAULT);
    }

    public SpellResultDto[] checkTextWithOptions(String text, Options... options) {
        return checkText(text, options);
    }

    //todo checkTextWithOptions и checkText получились с одной сигнатурой. Так что один из них можно и ликвидировать.
    //будь внимательнее!
    private SpellResultDto[] checkText(String text, Options... options) {
        String response =  new SpellerService()
                .getResponseForText(URI.GET_CORRECT_TEXT, text, options)
                .getBody().asString();

        return new Gson().fromJson(response, SpellResultDto[].class);
    }


    //Methods for "checkTexts" YandexSpeller method

    public SpellResultDto[] checkTextsWithoutOptions(String[] texts) {
        return checkTexts(texts, Options.DEFAULT);
    }

    public SpellResultDto[] checkTextsWithOptions(String[] texts, Options... options) {
        return checkTexts(texts, options);
    }

    private SpellResultDto[] checkTexts(String[] texts, Options... options) {
        String response =  new SpellerService()
                .getResponseForTexts(URI.GET_CORRECT_TEXTS, texts, options)
                .getBody().asString();

        return new Gson().fromJson(response, SpellResultDto[].class);
    }

    //fixed todo - в этих двух методах дублирование налицо! почему бы  getWithParams и getNoParams не заменить одним методом
    //get(String uri, String text, String... options)
    //тогда можно вынести общую часть методов checkTextWithoutOptions&checkTextWithOptions в еще один приватный метод
    //и вызывать уже ЕГО вместо доблирования кода

    //fixed todo куда потерялась checkTexts?
}
