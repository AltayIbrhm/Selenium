package com.Selenium.tests.day10_pom_synchronization_jsExecutor;

import com.Selenium.utilities.BrowserUtils;
import com.Selenium.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void p3_drag_and_drop(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Handling cookie pop-up (by clicking Agree button)
        BrowserUtils.sleep(2);
        WebElement cookieAgreeButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookieAgreeButton.click();

        //2. Drag and drop the small circle to bigger circle.
        //locating small circle
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //locating big circle
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //To be able to drag And drop we need to create Actions object
        Actions actions = new Actions(Driver.getDriver());

        //Use the actions object to reach Actions class methods
        //source --> what you want to click and hold. in our case; small circle.
        //target --> where you want to drop the "source" web element. in our case; big circle.
        BrowserUtils.sleep(2);
        actions.dragAndDrop(smallCircle, bigCircle).perform();
        //actions.perform();

        //actions.moveToElement(smallCircle).clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expected = "You did great!";
        String actual = bigCircle.getText();

        Assert.assertTrue(actual.equals(expected));

    }

    @Test
    public void p2_double_click_test(){
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        //3. Double click on the text “Double-click me to change my text color.”
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);
        //using this object we can double click to any web element
        actions.doubleClick(textToDoubleClick).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        String expected = "red";

        // will return attribute value of style
        //style="color: red;"
        String actual = textToDoubleClick.getAttribute("style");

        Assert.assertTrue(actual.contains(expected));

    }

    @AfterMethod
    public void tearDownMethod(){
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

}
