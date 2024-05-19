package caller;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import requests.AddProductRequest;

public class AddProductCaller {

    AddProductRequest addProductRequest = new AddProductRequest();

    public ValidatableResponse addAProduct() {
        return addProductRequest.addAProduct();
    }

    public void verifyAddedProduct(ValidatableResponse response) {
        response.assertThat().statusCode(200);
        Assert.assertEquals("101", response.extract().jsonPath().get("id").toString());
        Assert.assertEquals("HB Test", response.extract().jsonPath().get("title").toString());
    }
}
