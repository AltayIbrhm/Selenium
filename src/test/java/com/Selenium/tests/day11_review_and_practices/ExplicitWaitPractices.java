package com.Selenium.tests.day11_review_and_practices;

import com.Selenium.pages.DynamicLoad1Page;
import com.Selenium.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {


    @Test
    public void dynamic_load_page1(){
        //TC#41 : Dynamically Loaded Page Elements 1
        //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        //Creating the object of the class to be able to reach web elements from that class
        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();

        //2. Click to start
        dynamicLoad1Page.startButton.click();

        //3. Wait until loading bar disappears
        //To be able to wait until loading bar disappears we will use WebDriverWait class and its obj
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //using the object, we will create our expected condition: Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());

        //5. Enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("asdfasdf");

        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());

        //Note: Follow POM Design Pattern
    }

}
