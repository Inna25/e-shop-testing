package pageobject_model.service;

import pageobject_model.model.Product;

public class ProductCreator {

    private final static String PRODUCT_NAME = "product.name";
    private final static String PRODUCT_RANGE_NAME = "product.rangename";
    private final static String PRODUCT_BRAND_XPATH = "product.brand.xpath";
    private final static String PRODUCT_NAME_XPATH = "product.name.xpath";

    public static Product withAllProductParameters(){
        return new Product(TestDataReader.getTestData(PRODUCT_NAME), TestDataReader.getTestData(PRODUCT_RANGE_NAME),
                TestDataReader.getTestData(PRODUCT_BRAND_XPATH), TestDataReader.getTestData(PRODUCT_NAME_XPATH));
    }
    public static Product withRangeNameOnly(){
        return new Product("", TestDataReader.getTestData(PRODUCT_RANGE_NAME), "", "");
    }
}
