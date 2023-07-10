package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    private By searchField=By.id("search");
    private By searchButton=By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
    private By selectWatch=By.linkText("Bolo Sport Watch");
    private By wishListButton=By.className("towishlist");
    private By successMessage=By.className("message-success");
    private By searchResult=By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");

    @Step
    public void inputSearchField(String name){
        driver.findElement(searchField).sendKeys(name);
    }
    public String searchFieldPlaceHolder(){
        return driver.findElement(searchField).getAttribute("placeholder");
    }
    @Step
    public void clickSearch(){
        driver.findElement(searchButton).click();
    }
    @Step
    public void watchSelect(){driver.findElement(selectWatch).click();}
    public boolean searchFieldVis(){return driver.findElement(searchField).isDisplayed();}
    public String searchResultText(){return driver.findElement(searchResult).getText();}
    public String successMessageText(){return driver.findElement(successMessage).getText();}
    @Step
    public WishListPage addToWishList(){
        driver.findElement(wishListButton).click();
        return new WishListPage();
    }



}
