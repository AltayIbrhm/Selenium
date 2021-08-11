package com.Selenium.tests.day9_driver_actions_uploads;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_test1(){

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);

    }

    @Test
    public void singleton_test2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
    }

}
