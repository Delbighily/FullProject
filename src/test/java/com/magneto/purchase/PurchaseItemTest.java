package com.magneto.purchase;

import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

public class PurchaseItemTest extends BaseTest {
    @Test(description = "Testing adding to cart and deleting from cart")
    public void testNewPurchase (){

        SignInPage signInPage=homePage.clickOnSigninLink();
        signInPage.inputEmail();
        signInPage.inputPass();
        signInPage.pressLogin();

        //Before purchasing assertions
        Assert.assertTrue(purchaseItemPage.categoriesDivText().contains("What's New\n" + "Women\n" + "Men\n" + "Gear\n" + "Training\n" + "Sale"));

        //Purchasing Process
        purchaseItemPage.goToMenPage();
        purchaseItemPage.goToJacketsPage();
        purchaseItemPage.selectItem();
        purchaseItemPage.setSelectSize();
        purchaseItemPage.setSelectColor();
        purchaseItemPage.emptyField();
        purchaseItemPage.inputQuantity("3");
        purchaseItemPage.proceed();


        //Selections Assertions
        Assert.assertEquals(purchaseItemPage.getColorButtonText(),purchaseItemPage.getColorText(),"button text and selection text didn't match");
        Assert.assertEquals(purchaseItemPage.getSizeButtonText(),purchaseItemPage.getSizeText(),"button text and selection text didn't match");


        //Deleting Items Process
        purchaseItemPage.clickOnShoppingCart();
        purchaseItemPage.clickOnDeleteButton();

        //After delete assertion
        Assert.assertTrue(purchaseItemPage.afterDeleteMessage().contains("You have no items in your shopping cart"));
    }
}
