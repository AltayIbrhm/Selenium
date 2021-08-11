package com.Selenium.tests.day3_cssSelector_xpath;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P4_Xpath_Practice {

    public static void main(String[] args) throws InterruptedException{

        //go to this link: http://practice.cybertekschool.com/multiple_buttons

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //locate button2 USING XPATH LOCATOR

        WebElement button2 = driver.findElement(By.xpath("//button[.='Button 2']"));

        Thread.sleep(2000);
        button2.click();




    }

}
