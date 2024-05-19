package caller;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import requests.GetProductsRequest;

import java.util.ArrayList;

public class GetProductsCaller {

    GetProductsRequest getProductsRequest = new GetProductsRequest();

    public ValidatableResponse getAllProducts() {
        return getProductsRequest.getAllProducts();
    }

    public void verifyProductsListIsNotEmpty(ValidatableResponse response) {
        response.assertThat().statusCode(200);
        ArrayList<Object> products = response.extract().jsonPath().get("products");
        Assert.assertFalse("Products list is empty!", products.isEmpty());
    }

}
