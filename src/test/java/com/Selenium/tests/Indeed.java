package com.Selenium.tests;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Indeed {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.indeed.com/");
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
//    @AfterMethod
//    public void teardownMethod() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.close();
//    }


    @Test
    public void indeedTest(){

        WebElement searchButton = driver.findElement(By.id("text-input-what"));

            searchButton.sendKeys("Java Developer"+ Keys.ENTER);


            List<WebElement> allJavaStuff=  driver.findElements(By.xpath("//div[@class='mosaic mosaic-provider-jobcards mosaic-provider-hydrated']//a//div//table//tr//td/div/h2/span"));

            String a = "";

            for (WebElement allOfthem : allJavaStuff){
                List b = Collections.singletonList(allOfthem.getText());

                a+=b;

            }
        System.out.println(a);






            for (int i =0 ; i<=4; i++){

                System.out.println(a);
                WebElement c=driver.findElement(By.xpath("(//span[@class='pn'])"+"["+i+"]"));
                c.click();
                WebElement d= driver.findElement(By.xpath("//button[@class='popover-x-button-close icl-CloseButton']"));
                d.click();

            }

    }





}
