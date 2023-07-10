package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By createAccount= By.linkText("Create an Account");
    private By signin=By.linkText("Sign In");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public SignupPage clickOnSignupLink(){
        driver.findElement(createAccount).click();
        return new SignupPage(driver);
    }
    public SignInPage clickOnSigninLink(){
        driver.findElement(signin).click();
        return new SignInPage(driver);
    }
}
