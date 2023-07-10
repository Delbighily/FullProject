package com.magneto.signIn;

import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.utils.ConfigUtils;

import java.time.Duration;

public class SignInTest extends BaseTest {
@Test(description = "Test sign-in functionality using valid user data from property file")
    public void testSuccessfullSignin(){
    SignInPage signInPage=homePage.clickOnSigninLink();

    //pre sign in assertions
    Assert.assertEquals(signInPage.getTitle(),"Customer Login");
    Assert.assertEquals(signInPage.getHeader(),signInPage.getTitle());
    Assert.assertTrue(signInPage.emailVis(),"email field is not displayed");
    Assert.assertTrue(signInPage.passVis(),"password field is not displayed");
    Assert.assertTrue(signInPage.buttonVis(),"sign in button is not displayed");
    Assert.assertTrue(signInPage.ForgotPasswordVis());

    // Filling data in

    signInPage.inputEmail();
    signInPage.inputPass();
    signInPage.pressLogin();


    //after sign in assertions
    try {
        Thread.sleep(Duration.ofSeconds(2));
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    Assert.assertEquals(signInPage.getAfterHeader(),"Welcome, "+ ConfigUtils.getInstance().getFname()+" "+ConfigUtils.getInstance().getLname()+"!");
    }
}
