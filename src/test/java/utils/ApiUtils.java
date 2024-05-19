package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class ApiUtils {

    public static String env = ConfigUtils.getProperties("env");
    public static String baseUrl = getBaseUrl();

    public static String getBaseUrl() {
        switch (env) {
            case "test":
                baseUrl = ConfigUtils.getProperties("test_url");
                break;
            case "prod":
                baseUrl = ConfigUtils.getProperties("prod_url");
                break;
        }
        return baseUrl;
    }

    public static ValidatableResponse getRequest(String uri, String path, Map<String, String> header) {
        return RestAssured.given().relaxedHTTPSValidation().headers(header).get(uri + path).then();
    }

    public static ValidatableResponse postRequest(String uri, String path, String body, Map<String, String> options) {
        return RestAssured.given().relaxedHTTPSValidation().headers(options).body(body).post(uri + path).then();
    }
}