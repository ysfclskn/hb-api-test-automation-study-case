package stepDefinitions;

import caller.GetProductsCaller;
import caller.AddProductCaller;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;

public class ProductsSteps {

    GetProductsCaller getProductsCaller = new GetProductsCaller();
    AddProductCaller addProductCaller = new AddProductCaller();
    static ValidatableResponse response;

    @When("add a product")
    public void addAProduct() {
        response = addProductCaller.addAProduct();
    }

    @When("get all products")
    public void getAllProducts() {
        response = getProductsCaller.getAllProducts();
    }

    @Then("verify products list is not empty")
    public void verifyProductsListIsNotEmpty() {
        getProductsCaller.verifyProductsListIsNotEmpty(response);
    }

    @Then("verify added product")
    public void verifyAddedProduct() {
        addProductCaller.verifyAddedProduct(response);
    }

}
