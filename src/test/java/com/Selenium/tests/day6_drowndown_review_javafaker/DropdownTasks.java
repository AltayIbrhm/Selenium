package com.Selenium.tests.day6_drowndown_review_javafaker;

import com.Selenium.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

//    @BeforeClass
//    public void setupClass(){
//        //1. Open Chrome browser
//        driver = WebDriverFactory.getDriver("chrome");
//    }

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //maximize
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException {
        // We need to locate the dropdown and create Select class object
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois --> select by visible text
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia --> select by value
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California --> select by index
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOption = "California";

        //Finding currently selected option
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        //AssertEquals: expects args to compare

        Assert.assertEquals(actualOption, expectedOption, "Final selected option is not as expected.");

    }




    @Test
    public void test3_date_dropdown_verification() throws InterruptedException {

        //We need to locate all the dropdowns to be able to select options
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //for shortcut code moving:
        //mac: command + shift + d
        //window: control + shift + d

        //Select “December 1 , 1922” and verify it is selected.
        //   Select year using : visible text
        Thread.sleep(1000);
        yearDropdown.selectByVisibleText("1922");

        //   Select month using : value attribute
        Thread.sleep(1000);
        monthDropdown.selectByValue("11");

        //   Select day using : index number
        Thread.sleep(1000);
        dayDropdown.selectByIndex(0);

        //creating expected values
        String expectedYear = "1922";
        String expectedMonth = "December";
        String expectedDay = "1";


        //getting our actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay= dayDropdown.getFirstSelectedOption().getText();

        //creating assertions to compare actual vs expected values

        //AssertTrue expects one argument that is supposed to be returning boolean value
        Assert.assertTrue(actualYear.equals(expectedYear), "ActualYear is not equal to ExpectedYear!!!");

        Assert.assertTrue(actualMonth.equals(expectedMonth));

        Assert.assertEquals(actualDay, expectedDay);


    }

    @Test
    public void test4_multiple_select_dropdown() throws InterruptedException {

        //Locating dropdown to work on it
        Select multipSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //3. Select all the options from multiple select dropdown.
        List<WebElement> allOptions = multipSelectDropdown.getOptions();
        
        //Loop through the List and click to each option
        //iter for creating short cut for:each loop
        for (WebElement each : allOptions) {

            Thread.sleep(500);
            each.click();

            //4. Print out all selected values.
            System.out.println("Selected: " + each.getText());

            //Verifying each option is selected:
            Assert.assertTrue(each.isSelected(), "The option "+each.getText()+" is not selected!");
        }

        //5. Deselect all values.
        multipSelectDropdown.deselectAll();

        for (WebElement each : allOptions) {
            //assertTrue expecting true boolean value to pass the test
            //Assert.assertTrue(!each.isSelected());

            //Assert.assertFalse method is expecting "false" boolean value to pass the test.
            //If expected result is "false" better to use this assertFalse
            Assert.assertFalse(each.isSelected());
        }




    }

    @Test
    public void test5_non_select_dropdown() throws InterruptedException {

        //We need to locate the non-select dropdown as regular web element
        WebElement websiteDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));

        //3. Click to non-select dropdown
        Thread.sleep(1000);
        websiteDropdown.click();

        //4. Select Facebook from dropdown
        Thread.sleep(1000);

        //Locating Facebook from non-select dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        //Click to facebook link to go to page
        facebookLink.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected!!!");



    }




    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

        driver.close();

    }

}
