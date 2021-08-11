package com.Selenium.utilities;

/*
We will create utility methods for repeated steps that can be used
in browsers, and store in this class.
 */

public class BrowserUtils {

   //create method name: wait
   //converting milliseconds to seconds
   //handle checked exception

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }

}
//Whare are the most important things you d like to see someone accomplish in the first
//30,60 and 90days on this job?

//  Whattraining programs are available to your employees?

//What gets you most excited about the company's future?

//Who will I report to directly?

//What are the team's biggest challanges?
