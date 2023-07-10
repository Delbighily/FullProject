package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.utils.ConfigUtils;

public class CartCheckOutPage {
    private WebDriver driver;
    public CartCheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By cart=By.className("showcart");
    private By cartLink =By.linkText("shopping cart");
    private By checkOutButton=By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button");
    private By floorField=By.name("street[0]");
    private By buildingField=By.name("street[1]");
    private By streetField=By.name("street[2]");
    private By cityField=By.name("city");
    private By countrySelector=By.name("country_id");
    private By zipField=By.name("postcode");
    private By phoneNumberField=By.name("telephone");
    private By continueButton=By.className("continue");
    private By placeOrderButton= By.className("checkout");
    private By successPurchaseMsg= By.className("page-title");
    @Step
    public void clickOnCart(){
        driver.findElement(cart).click();
    }
    @Step
    public void goToCartPage(){
        driver.findElement(cartLink).click();
    }
    @Step
    public void clickCheckOut(){
        driver.findElement(checkOutButton).click();
    }
    @Step
    public void inputFloorField(){
        driver.findElement(floorField).sendKeys(ConfigUtils.getInstance().getFloor());
    }
    @Step
    public void inputBuildingField(){
        driver.findElement(buildingField).sendKeys(ConfigUtils.getInstance().getBuilding());
    }
    @Step
    public void inputStreetField(){
        driver.findElement(streetField).sendKeys(ConfigUtils.getInstance().getStreet());
    }
    @Step
    public void inputCityField(){
        driver.findElement(cityField).sendKeys(ConfigUtils.getInstance().getCity());
    }
    @Step
    public void inputZipField(){
        driver.findElement(zipField).sendKeys(ConfigUtils.getInstance().getZip());
    }
    @Step
    public void inputPhoneField(){driver.findElement(phoneNumberField).sendKeys(ConfigUtils.getInstance().getPhone());}
    @Step
    public void clickOnNext(){driver.findElement(continueButton).click();}
    @Step
    public void clickOnPlaceOrder(){driver.findElement(placeOrderButton).click();}
    @Step
    public void selectCountryDrop(){
        Select country= new Select(driver.findElement(countrySelector));
        country.selectByVisibleText(ConfigUtils.getInstance().getCountry());
    }
    public String getSuccessMsgText(){return driver.findElement(successPurchaseMsg).getText();}
}
