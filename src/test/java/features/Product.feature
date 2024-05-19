Feature: DummyJSON Api Test Suite

  @smoke
  Scenario: Add A Product
    When add a product
    Then verify added product

  @smoke
  Scenario: Get All Products
    When get all products
    Then verify products list is not empty