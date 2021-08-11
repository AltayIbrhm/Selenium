package com.Selenium.tests.day9_driver_actions_uploads;

import com.Selenium.utilities.BrowserUtils;
import com.Selenium.utilities.ConfigurationReader;
import com.Selenium.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {


    @Test
    public void simple_google_search_test(){

        //Go to google.com

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.google.com");

        //Driver.getDriver() = driver
        String url = ConfigurationReader.getProperty("googleUrl");
        Driver.getDriver().get(url);

        //Search for a value
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String searchValue = ConfigurationReader.getProperty("searchValue");

        searchBox.sendKeys(searchValue + Keys.ENTER);

        //Assert title contains the value

        //actual --> actual page, browser
        BrowserUtils.sleep(4);
        String actualTitle = Driver.getDriver().getTitle();

        //expected --> comes from documentation
        String expectedInTitle = searchValue;

        //We are adding 2 seconds just to wait for Firefox to catch up

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedInTitle = " + expectedInTitle);

        Assert.assertTrue(actualTitle.contains(expectedInTitle));


        //Calling the custom method we created to close the browser from Driver class
        Driver.closeDriver();

        //Driver.getDriver().close();
        //Driver.getDriver().quit();

        Driver.getDriver().get("https://www.etsy.com");



    }




}
