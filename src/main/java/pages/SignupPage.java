package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.ConfigUtils;

public class SignupPage {
    private WebDriver driver;
    ConfigUtils configUtils=new ConfigUtils();
    private By firstNameField = By.id("firstname");
    private By header = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By submitButton = By.className("submit");
    private By successMessage = By.className("message-success");
    public SignupPage(WebDriver driver){
        this.driver=driver;
    }
    @Step
    public void setFirstName(){
        driver.findElement(firstNameField).sendKeys(configUtils.getFname());
    }
    @Step
    public void setlastName(){
        driver.findElement(lastNameField).sendKeys(configUtils.getLname());
    }
    @Step
    public void setEmail(){driver.findElement(emailField).sendKeys(configUtils.getEmail());}
    @Step
    public void setPassword(){
        driver.findElement(passwordField).sendKeys(configUtils.getPassword());
    }
    @Step
    public void setCPassword(){
        driver.findElement(confirmPasswordField).sendKeys(configUtils.getPassword());
    }
    @Step
    public String getSuccessMessage(){return driver.findElement(successMessage).getText();}
    public String getTitle(){return driver.getTitle();}
    public String getHeader(){return driver.findElement(header).getText();}
    public boolean firstNameVis(){return driver.findElement(firstNameField).isDisplayed();}
    public boolean lastNameVis(){return driver.findElement(lastNameField).isDisplayed();}
    public boolean emailVis(){return driver.findElement(emailField).isDisplayed();}
    public boolean passVis(){return driver.findElement(passwordField).isDisplayed();}
    public boolean CpassVis(){return driver.findElement(confirmPasswordField).isDisplayed();}
    public boolean buttonVis(){return driver.findElement(submitButton).isDisplayed();}
    @Step
    public AfterSignup clickSubmit(){
        driver.findElement(submitButton).click();
        return new AfterSignup(driver);
    }

}
