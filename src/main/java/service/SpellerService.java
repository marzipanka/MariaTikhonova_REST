package service;

import enums.Options;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SpellerService {

    public RequestSpecification REQUEST_SPECIFICATION;

    public SpellerService() {

        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getProperty("json_interface"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public static String getProperty(String prop) {

        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("./src/test/resources/properties/test.properties")) {
            if (input == null) {
                System.out.println("test.properties file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e);
        }

        return properties.getProperty(prop);
    }

    public Response getNoParams(String uri, String text) {
        return given(REQUEST_SPECIFICATION).param(("options"), Options.DEFAULT).param("text", text).get(uri);
    }

    public Response getWithParams(String uri, String text, List<Options> params) {

        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Options param : params) {
            specification.param(("options"), param);
        }

        specification.param("text", text);

        return specification.get(uri);
    }
}
