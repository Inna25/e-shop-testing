package pageobject_model.service;

import pageobject_model.model.Product;

public class ProductCreator {

    private final static String PRODUCT_NAME = "Eau de parfum intense";             //"Eau de parfum intense"; "product.name"
    private final static String PRODUCT_RANGE_NAME = "LIBRE";                       //"LIBRE";  "product.rangename"

    public static Product withProductNameAndRangeName(){
        return new Product(PRODUCT_NAME, PRODUCT_RANGE_NAME);
    }
    public static Product withProductNameOnly(){
        return new Product(PRODUCT_NAME, "");
    }
    public static Product withRangeNameOnly(){
        return new Product("", PRODUCT_RANGE_NAME);
    }
}
