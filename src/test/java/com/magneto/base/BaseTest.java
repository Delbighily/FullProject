package com.magneto.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    protected PurchaseItemPage purchaseItemPage;
    protected SearchPage searchPage;
    protected RateProductPage rateProductPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage =new HomePage(driver);
        purchaseItemPage=new PurchaseItemPage(driver);
        searchPage=new SearchPage(driver);
        rateProductPage=new RateProductPage(driver);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        String testCaseName= result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
            takeScreenShot(destFile);
        }
        driver.quit();
        }


        public void takeScreenShot(File destFile){
        File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destFile);
            InputStream is =new FileInputStream(destFile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException("not");
        }


    }
    }
