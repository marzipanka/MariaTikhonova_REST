package service;

import com.google.gson.Gson;
import dto.SpellResultDto;
import enums.Options;

import java.util.List;

public class SpellerSteps {

    public SpellResultDto[] checkTextWithoutOptions(String text) {

        String response = new SpellerService()
                .getNoParams(URI.GET_CORRECT_TEXT, text)
                .getBody().asString();

        return new Gson().fromJson(response, SpellResultDto[].class);
    }

    public SpellResultDto[] checkTextWithOptions(String text, List<Options> options) {

        String response =  new SpellerService()
                .getWithParams(URI.GET_CORRECT_TEXT, text, options)
                .getBody().asString();

        return new Gson().fromJson(response, SpellResultDto[].class);
    }

    //todo - в этих двух методах дублирование налицо! почему бы  getWithParams и getNoParams не заменить одним методом
    //get(String uri, String text, String... options)
    //тогда можно вынести общую часть методов checkTextWithoutOptions&checkTextWithOptions в еще один приватный метод
    //и вызывать уже ЕГО вместо доблирования кода

    //todo куда потерялась checkTexts?
}
