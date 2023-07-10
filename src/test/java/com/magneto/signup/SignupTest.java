package com.magneto.signup;

import com.magneto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AfterSignup;
import pages.SignupPage;

public class SignupTest extends BaseTest {
    @Test(description = "Test sign-up functionality using valid data from properties file")
    public void testSuccessfullSignup(){
        SignupPage signupPage= homePage.clickOnSignupLink();

        // Before sign Up assertions

        Assert.assertEquals(signupPage.getHeader(),signupPage.getTitle());
        Assert.assertTrue(signupPage.firstNameVis(),"first name field is not visible");
        Assert.assertTrue(signupPage.lastNameVis(),"last name field is not visible");
        Assert.assertTrue(signupPage.emailVis(),"email field is not visible");
        Assert.assertTrue(signupPage.passVis(),"password field is not visible");
        Assert.assertTrue(signupPage.CpassVis(),"confirm password field is not visible");
        Assert.assertTrue(signupPage.buttonVis(),"create account button is not visible");

        // Filling form
        signupPage.setFirstName();
        signupPage.setlastName();
        signupPage.setEmail();
        signupPage.setPassword();
        signupPage.setCPassword();
        signupPage.clickSubmit();

        // After Sign up assertions
        Assert.assertEquals(signupPage.getSuccessMessage(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(signupPage.getTitle(),"My Account");
    }
}
