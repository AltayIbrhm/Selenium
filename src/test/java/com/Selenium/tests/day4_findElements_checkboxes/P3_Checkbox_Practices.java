package com.Selenium.tests.day4_findElements_checkboxes;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class P3_Checkbox_Practices {

    public static void main(String[] args) throws InterruptedException {
        //Practice: Cybertek Checkboxes
        //1. Go to http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //LOCATING CHECKBOXES
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        // another option as locator for checkboxes: //form[@id='checkboxes']/input[1]
        // another option as locator for checkboxes: //form[@id='checkboxes']/input[2]

        //2. Confirm checkbox #1 is NOT selected by default
        if(!checkbox1.isSelected()){
            System.out.println("Checkbox#1 is NOT selected. Default value verification PASSED! ");
        }else{
            System.out.println("Checkbox#1 is selected. Default value verification FAILED!!!");
        }

        //3. Confirm checkbox #2 is SELECTED by default.
        if (checkbox2.isSelected()){
            System.out.println("Checkbox#2 is selected. Default value verification PASSED!!!");
        }else{
            System.out.println("Checkbox#2 is NOT selected. Default value verification FAILED!");
        }

        //4. Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        if (checkbox1.isSelected()){
            System.out.println("Checkbox#1 is selected. Verification PASSED!!!");
        }else{
            System.out.println("Checkbox#1 is NOT selected. Verification FAILED!");
        }
        //7. Confirm checkbox #2 is NOT selected.
        if(!checkbox2.isSelected()){
            System.out.println("Checkbox#2 is NOT selected. Verification PASSED! ");
        }else{
            System.out.println("Checkbox#2 is selected. Verification FAILED!!!");
        }


        //CLicking to home link

        driver.findElement(By.linkText("Home")).click();

        //navigate back to same page
        Thread.sleep(2000);
        driver.navigate().back();

        //re-locating the web element to refresh the driver's reference to it
        checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        //clicking to checkbox1
        checkbox1.click();





    }
}
