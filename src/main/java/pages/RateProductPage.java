package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RateProductPage {


    private WebDriver driver;

    public RateProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By goToReviewSection=By.id("tab-label-reviews-title");
    private By summaryTxtField=By.id("summary_field");
    private By reviewTxtField=By.id("review_field");
    private By submitButton=By.className("submit");
    private By successMessage=By.className("message-success");

    @Step
    public void clickOnReviewsToggle(){driver.findElement(goToReviewSection).click();}
    @Step
    public void give4StarRate(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fourStar= driver.findElement(By.id("Rating_4"));
        js.executeScript("arguments[0].click();", fourStar);
    }
    @Step
    public void writeSummary(){driver.findElement(summaryTxtField).sendKeys("nice Jacket");}
    @Step
    public void writeReview(){driver.findElement(reviewTxtField)
            .sendKeys("nice Jacket to have good value for the money, nice variety of colors");}
    @Step
    public void clickSubmit(){driver.findElement(submitButton).click();}
    public String getMessageText(){return driver.findElement(successMessage).getText();}

}
