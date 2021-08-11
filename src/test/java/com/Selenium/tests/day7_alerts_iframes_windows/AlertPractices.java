package com.Selenium.tests.day7_alerts_iframes_windows;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {
    WebDriver driver; //driver9q1283718923712397

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //TC #1: Information alert practice

    @Test
    public void p1_information_alert_test() throws InterruptedException {
        //Locating the button for alert to click
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //3.Clicking to the button for alert to be displayed
        informationAlertButton.click();

        Thread.sleep(2000);

        //4. Click to OK button from the alert
        //Switching driver's focus to alert
        Alert alert = driver.switchTo().alert();

        //Use 'alert' instance to click and close the alert
        alert.accept();

        //5. Verify "You successfully clicked an alert" text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));

        String actualText = resultText.getText();
        String expectedText = "You successfuly clicked an alert";

        Assert.assertTrue(resultText.isDisplayed());
        Assert.assertEquals(actualText, expectedText);





    }




    //AfterMethod will wait 5 seconds before closing the browser
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
