package com.magneto.search;

import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SignInPage;

public class SearchTest extends BaseTest {
@Test(description = "Test search for a product using provided keyword")
    public void TestSearchFunction(){
    SignInPage signInPage=homePage.clickOnSigninLink();

    //Before search assertion
    Assert.assertTrue(searchPage.searchFieldVis(),"search field is not visible");
    Assert.assertEquals(searchPage.searchFieldPlaceHolder(),"Search entire store here...");

    //Login process
    signInPage.inputEmail();
    signInPage.inputPass();
    signInPage.pressLogin();

    //search process
    searchPage.inputSearchField("watch");
    searchPage.clickSearch();

    //After Search assertion
    Assert.assertTrue(searchPage.searchResultText().contains("watch"),"search result is not valid");

    //Add to wishlist
    searchPage.watchSelect();
    searchPage.addToWishList();

    //Assert item has been added successfully
    Assert.assertTrue(searchPage.successMessageText()
            .contains("has been added to your Wish List. Click here to continue shopping."));
}
}
