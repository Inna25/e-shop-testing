package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.model.Product;
import pageobject_model.page.HomePage;
import pageobject_model.page.SearchedProductPage;
import pageobject_model.service.ProductCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MarionnaudTest extends BaseTest{
    private HomePage homePage;
    private final static String SEARCHED_PRODUCT_RANGE_NON_EXISTENT_NAME = "LIBRE NON EXISTENT";

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        homePage = new HomePage(driver).openPage().closeBanner();
    }

//    @Test(description = "Some products contained keyword in the name were found while using a mouse")
//    public void searchProductResultsNotEmptyTest() {
//        Product searchedProduct = ProductCreator.withRangeNameOnly();
//        int searchResultsNumber = homePage
//                .searchForTermUsingSearchButtonClick(searchedProduct.getRangeName())
//                .countSearchResults();
//        Assert.assertTrue(searchResultsNumber > 0, "Search result is empty!");
//    }
//
//    @Test(description = "Some products contained keyword in the name were found while using the keyboard")
//    public void searchProductResultsNotEmptyUsingKeyboardTest() {
//        Product searchedProduct = ProductCreator.withRangeNameOnly();
//        int searchResultsNumber = homePage
//                .searchForTermUsingKeyboard(searchedProduct.getRangeName())
//                .countSearchResults();
//        Assert.assertTrue(searchResultsNumber > 0, "Search result is empty!");
//    }
//
//    @Test(description = "Make sure that specified product is out")
//    public void certainProductIsOutTest() {
//        int searchResultsNumber = homePage
//                .searchForTermUsingSearchButtonClick(SEARCHED_PRODUCT_RANGE_NON_EXISTENT_NAME)
//                .countSearchResults();
//        Assert.assertTrue(searchResultsNumber == 0, "Products were found ");
//    }
//
    @Test(description = "Search for a certain product using menu")
    public void searchForCertainProductUsingMenuTest() {
        Product searchedProduct = ProductCreator.withAllProductParameters();
        SearchedProductPage searchedProductPage = homePage.gotoParfumPage()
                .gotoParfumFemmePage()
                .gotoSearchedProductPage(searchedProduct);
        assertThat(searchedProductPage.getProductName(), is(equalTo(searchedProduct.getName())));
        assertThat(searchedProductPage.getProductRangeName(), is(equalTo(searchedProduct.getRangeName())));
    }

//    @Test
//    public void appearsSubmenuForParfumMenuItem() {
//
//        Assert.assertTrue(homePage.hoverOverMenuItemParfum());
//    }
}
