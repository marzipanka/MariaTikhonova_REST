package service;

import enums.Options;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ProjectProperties;

import static io.restassured.RestAssured.given;

public class SpellerService {

    public RequestSpecification REQUEST_SPECIFICATION;

    public SpellerService() {

        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(ProjectProperties.properties.getProperty("json_interface"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public Response getResponseForText(String uri, String text, Options... params) {
        RequestSpecification specification = buildRequest(params);

        specification.param("text", text);
        return specification.get(uri);
    }

    public Response getResponseForTexts(String uri, String[] texts, Options... params) {
        RequestSpecification specification = buildRequest(params);

        specification.param("text", texts);
        return specification.get(uri);
    }

    private RequestSpecification buildRequest(Options... params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Options param : params) {
            specification.param(("options"), param);
        }
        return specification;
    }
}
