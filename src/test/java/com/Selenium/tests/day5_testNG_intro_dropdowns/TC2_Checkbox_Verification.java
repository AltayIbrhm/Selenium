package com.Selenium.tests.day5_testNG_intro_dropdowns;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_Checkbox_Verification {

    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //maximize our browser
        driver.manage().window().maximize();

        //creating implicit wait for our findElement method
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //3. Verify “Success – Check box is checked” message is NOT displayed.

        //Option #1: Using xpath and id attribute value to locate successMessage
        //Option #2: Using xpath and style attribute value: //div[@style='display: block;']
        //Option #3: Using xpath and text value: //div[.='Success - Check box is checked']
        //Option #4: Using xpath and text value: //div[text()='Success - Check box is checked']
        //Option #5: Using xpath and * instead of tagName: //*[@id=“txtAge”]
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        //Locating checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        if (!checkbox1.isSelected() && !successMessage.isDisplayed()){
            System.out.println("Checkbox is not selected. Message is not displayed. Verification PASS!");
        }else{
            System.out.println("FAIL!");
        }

        //4. Click to checkbox under “Single Checkbox Demo” section
        Thread.sleep(2000);

        checkbox1.click();

        //5. Verify “Success – Check box is checked” message is displayed.
        if (checkbox1.isSelected() && successMessage.isDisplayed()){
            System.out.println("Checkbox is selected. Message is displayed. Verification PASS!");
        }else{
            System.out.println("FAIL!");
        }

        Thread.sleep(2000);

        driver.close();


    }
}
