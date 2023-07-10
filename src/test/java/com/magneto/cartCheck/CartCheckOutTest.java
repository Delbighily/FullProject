package com.magneto.cartCheck;

import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartCheckOutPage;
import pages.SignInPage;

import java.time.Duration;

public class CartCheckOutTest extends BaseTest {
    @Test(description = "Testing completing full purchase process")
    public void checkOutFromCartPage() throws InterruptedException {
        SignInPage signInPage=homePage.clickOnSigninLink();
        signInPage.inputEmail();
        signInPage.inputPass();
        signInPage.pressLogin();
        purchaseItemPage.goToMenPage();
        purchaseItemPage.goToJacketsPage();
        purchaseItemPage.selectItem();
        purchaseItemPage.setSelectSize();
        purchaseItemPage.setSelectColor();
        purchaseItemPage.emptyField();
        purchaseItemPage.inputQuantity("3");
        CartCheckOutPage cartCheckOutPage=purchaseItemPage.proceed();
        cartCheckOutPage.clickOnCart();
        cartCheckOutPage.goToCartPage();
        cartCheckOutPage.clickCheckOut();

        //for the first purchase of the account

        cartCheckOutPage.selectCountryDrop();
        cartCheckOutPage.inputCityField();
        cartCheckOutPage.inputBuildingField();
        cartCheckOutPage.inputFloorField();
        cartCheckOutPage.inputStreetField();
        cartCheckOutPage.inputZipField();
        cartCheckOutPage.inputPhoneField();
        cartCheckOutPage.clickOnNext();

        //any upcoming purchases

        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cartCheckOutPage.clickOnNext();
        Thread.sleep(Duration.ofSeconds(6));
        cartCheckOutPage.clickOnPlaceOrder();
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(cartCheckOutPage.getSuccessMsgText(),"Thank you for your purchase!");
    }

}
