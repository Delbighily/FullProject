package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseItemPage {
    private WebDriver driver;
    private By mensLink =By.id("ui-id-5");
    private By categoriesDiv=By.id("ui-id-2");
    private By jacketsLink =By.linkText("Jackets");
    private By selectJacket =By.linkText("Typhon Performance Fleece-lined Jacket");
    private By selectSize =By.id("option-label-size-143-item-168");
    private By selectColor =By.id("option-label-color-93-item-53");
    private By quantity=By.id("qty");
    private By addToCart=By.id("product-addtocart-button");
    private By shoppingCartLink =By.linkText("shopping cart");
    private By deleteItemsButton =By.className("action-delete");
    private By deleteItemsMessage =By.className("cart-empty");
    private By sizeText=By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/span[2]");
    private By colorText=By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/span[2]");
    public PurchaseItemPage(WebDriver driver){
        this.driver=driver;
    }
    @Step
    public void goToMenPage(){
        driver.findElement(mensLink).click();
    }
    @Step
    public void goToJacketsPage(){
        driver.findElement(jacketsLink).click();
    }
    @Step
    public void selectItem(){
        driver.findElement(selectJacket).click();
    }
    @Step
    public void setSelectSize(){
        driver.findElement(selectSize).click();
    }
    @Step
    public void setSelectColor(){
        driver.findElement(selectColor).click();
    }
    public void emptyField(){driver.findElement(quantity).clear();}
    public String categoriesDivText(){return driver.findElement(categoriesDiv).getText();}
    @Step
    public void inputQuantity(String number){driver.findElement(quantity).sendKeys(number);}
    @Step
    public CartCheckOutPage proceed(){
        driver.findElement(addToCart).click();
        return new CartCheckOutPage(driver);
    }
    @Step
    public void clickOnShoppingCart(){
        driver.findElement(shoppingCartLink).click();
    }
    @Step
    public void clickOnDeleteButton(){driver.findElement(deleteItemsButton).click();}
    public String afterDeleteMessage(){return driver.findElement(deleteItemsMessage).getText();}
    public String getSizeButtonText(){return driver.findElement(selectSize).getText();}
    public String getColorButtonText(){return driver.findElement(selectColor).getAttribute("option-label");}
    public String getSizeText(){return driver.findElement(sizeText).getText();}
    public String getColorText(){return driver.findElement(colorText).getText();}


}
