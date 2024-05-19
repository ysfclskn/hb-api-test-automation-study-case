package requests;

import io.restassured.response.ValidatableResponse;
import utils.ApiUtils;

import java.util.HashMap;
import java.util.Map;

public class AddProductRequest extends ApiUtils {

    Map<String, String> headersOpt = new HashMap<>();

    public ValidatableResponse addAProduct() {
        String body = "{\"title\": \"HB Test\"}";
        headersOpt.put("Content-Type", "application/json");
        return postRequest(baseUrl, "/products/add", body, headersOpt);
    }
}
