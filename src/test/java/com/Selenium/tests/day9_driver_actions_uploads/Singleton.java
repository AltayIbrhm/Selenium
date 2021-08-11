package com.Selenium.tests.day9_driver_actions_uploads;

public class Singleton {

    //By making the constructor private, we are limiting creating object from this class
    private Singleton(){}

    //By making the String, we can only reach this using getter method
    private static String word;

    //By creating 'getter' method, we will allow user to reach to String in the way we allow them to
    public static String getWord(){

        if(word == null){
            System.out.println("First time call. Word object is null" +
                    "Assigning value to it now.");
            word = "something";
        }else{
            System.out.println("Word already has a value.");
        }

        return word;
    }

}
