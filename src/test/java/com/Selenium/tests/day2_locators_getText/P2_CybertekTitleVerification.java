package com.Selenium.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekTitleVerification {

    public static void main(String[] args) {

        //TC #2: Cybertek verifications
        //1. Open Chrome browser
        //setup my driver
        WebDriverManager.chromedriver().setup();
        //open browser
        WebDriver driver = new ChromeDriver();

        //2. Go to https://practice.cybertekschool.com
        driver.get("http://practice.cybertekschool.com");

        //3. Verify URL contains
        //Expected: cybertekschool
        String expectedInUrl = "cybertekschool";
        String actualUrl =  driver.getCurrentUrl();

        System.out.println("expectedInUrl = " + expectedInUrl);
        System.out.println("actualUrl = " + actualUrl);

        if (actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification PASSED!");
        }else{
            System.err.println("URL verification FAILED!!!");
        }

        //4. Verify title:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!!!");
        }else{
            System.err.println("Title verification FAILED!!!");
        }


        driver.close();

    }
}
