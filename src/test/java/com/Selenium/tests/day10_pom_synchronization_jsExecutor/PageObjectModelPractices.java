package com.Selenium.tests.day10_pom_synchronization_jsExecutor;

import com.Selenium.pages.LoginPage;
import com.Selenium.utilities.ConfigurationReader;
import com.Selenium.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractices {

    @Test
    public void login_to_smartBear(){

        String url = ConfigurationReader.getProperty("webOrderUrl");
        Driver.getDriver().get(url);

        //Driver.getDriver().get(ConfigurationReader.getProperty("webOrderUrl"));

        //When we create object of this class, the object and driver instance will be
        // already initialized (recognize each other.)
        LoginPage loginPage = new LoginPage();

        //We are allowed to use object of this class to reach web elements and use selenium methods

        //Sending username using object of LoginPage and web element (that has been located in LoginPage)
        String username = ConfigurationReader.getProperty("usernameSmartBear");
        loginPage.inputUsername.sendKeys(username);



        String password = ConfigurationReader.getProperty("passwordSmartBear");
        loginPage.inputPassword.sendKeys(password);

        loginPage.loginButton.click();



    }

}
