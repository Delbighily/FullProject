package com.magneto.Rate;


import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PurchaseItemPage;
import pages.RateProductPage;
import pages.SignInPage;

import java.time.Duration;

@Test(description = "Testing giving a review function")
public class RateProductTest extends BaseTest {
    public void testSuccessfulProductRate(){

        SignInPage signInPage=homePage.clickOnSigninLink();
        signInPage.inputEmail();
        signInPage.inputPass();
        signInPage.pressLogin();
        purchaseItemPage.goToMenPage();
        purchaseItemPage.goToJacketsPage();
        purchaseItemPage.selectItem();
        rateProductPage.clickOnReviewsToggle();
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rateProductPage.give4StarRate();
        rateProductPage.writeSummary();
        rateProductPage.writeReview();
        rateProductPage.clickSubmit();

        //Assert that review has been submitted
        Assert.assertTrue(rateProductPage.getMessageText().contains("You submitted your review for moderation"),
                "confirmation message is not visible");
    }


}
