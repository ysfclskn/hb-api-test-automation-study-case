package requests;

import io.restassured.response.ValidatableResponse;
import utils.ApiUtils;

import java.util.HashMap;
import java.util.Map;

public class GetProductsRequest extends ApiUtils {
    Map<String, String> headersOpt = new HashMap<>();

    public ValidatableResponse getAllProducts() {
        headersOpt.put("Content-Type", "application/json");
        return getRequest(baseUrl, "/products", headersOpt);
    }

    public ValidatableResponse getAddedProducts(ValidatableResponse response) {
        headersOpt.put("Content-Type", "application/json");
        String productId = response.extract().jsonPath().get("id");
        return getRequest(baseUrl, "/products/" + productId, headersOpt);
    }
}
