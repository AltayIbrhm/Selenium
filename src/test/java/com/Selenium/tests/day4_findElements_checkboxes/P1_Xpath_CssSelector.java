package com.Selenium.tests.day4_findElements_checkboxes;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Xpath_CssSelector {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");



        //a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));

        //Locating the same link using class attribute's value
        //WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //Locating the same link using href attribute's value
        //WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));

        //b. “Forgot password” header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));
        //Locating the label using its TEXT with XPATH
        //WebElement emailLabel = driver.findElement(By.xpath("//label[.='E-mail']"));

        //d. E-mail input box
        //Using syntax #1, tagName[attribute='value']
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));

        //Option #2: Using "name" attribute to locate the same web element
        //WebElement emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));

        //e. “Retrieve password” button
        //Locating the button using #2 cssSelector syntax.
        //tagName.classValue
        //tagName#idValue

        //locating using id value
        //WebElement retrievePasswordButton = driver.findElement(By.cssSelector("#form_submit"));

        //locating using class value
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button.radius"));

        //f. “Powered by Cybertek School” text
        WebElement footerText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all WebElements are displayed.

        if(homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed()
        && emailLabel.isDisplayed() && emailInputBox.isDisplayed()
        && retrievePasswordButton.isDisplayed() && footerText.isDisplayed() ){
            System.out.println("ALL WEB ELEMENTS ARE DISPLAYED. VERIFICATION PASSED!");
        }else{
            System.out.println("One or more of the web elements are not displayed. Verification FAILED!!!");
        }

        //BREAK UNTIL 12.10PM CST
        //BREAK UNTIL 1.10PM EST
    }
}
