package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.ConfigUtils;

public class SignInPage  {
    private WebDriver driver;
    private By emailField=By.id("email");
    private By passwordField=By.name("login[password]");
    private By signInButton=By.id("send2");
    private By header = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1");
    private By afterSignInHeader = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span");
    private By afterSignInMail = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p/text()[2]");
    private By forgotPassword=By.className("remind");




    //    Methods
    public SignInPage (WebDriver driver){
        this.driver=driver;
    }
    @Step
    public void inputEmail(){
        driver.findElement(emailField).sendKeys(ConfigUtils.getInstance().getEmail());
    }
    @Step
    public void inputPass(){
        driver.findElement(passwordField).sendKeys(ConfigUtils.getInstance().getPassword());
    }
    public String getHeader(){return driver.findElement(header).getText();}
    public String getAfterHeader(){return driver.findElement(afterSignInHeader).getText();}
    public String getTitle(){return driver.getTitle();}
    public String verifyUsedMail(){return driver.findElement(afterSignInMail).getText();}
    public boolean emailVis(){return driver.findElement(emailField).isDisplayed();}
    public boolean passVis(){return driver.findElement(passwordField).isDisplayed();}
    public boolean buttonVis(){return driver.findElement(signInButton).isDisplayed();}
    public boolean ForgotPasswordVis(){return driver.findElement(forgotPassword).isDisplayed();}
    @Step
    public PurchaseItemPage pressLogin(){
        driver.findElement(signInButton).click();
        return new PurchaseItemPage(driver);
    }
}
