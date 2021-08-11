package com.Selenium.tests.day8_testbase_properties_driver;

import com.Selenium.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_from_properties_file() throws IOException {
        //#1- Create Properties class object
        Properties properties = new Properties();

        //#2- Open the file in JVM Memory and pass the path of the file
        String path = "configuration.properties";
        //For windows > copy path > copy path from content root

        FileInputStream file = new FileInputStream(path);

        //#3- Load the opened file into the Properties object.

        properties.load(file);

        //read some values from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        //write statement that is returning johndoe
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }

    @Test
    public void using_properties_util_method(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"url\") = " + ConfigurationReader.getProperty("url"));
    }


}
