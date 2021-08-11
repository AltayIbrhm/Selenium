package com.Selenium.tests.day6_drowndown_review_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {


    @Test
    public void java_faker_test1(){
        //We need to create an object of the JavaFaker
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        String address = faker.address().fullAddress();
        System.out.println("address = " + address);

        String gameOfThrones = faker.gameOfThrones().house();
        String gotQuote = faker.gameOfThrones().quote();

        System.out.println("gotQuote = " + gotQuote);
        System.out.println("gameOfThrones = " + gameOfThrones);

        String chuckNorrisFact = faker.chuckNorris().fact();
        System.out.println("chuckNorrisFact = " + chuckNorrisFact);

        String ssn = faker.idNumber().ssnValid();

        System.out.println("ssn = " + ssn);

    }
}
