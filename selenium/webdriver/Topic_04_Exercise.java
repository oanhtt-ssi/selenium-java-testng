package webdriver;

import org.testng.annotations.Test;

public class Topic_04_Exercise {
    @Test
    public void TC_01(){
        String name = "Na";
        int age = 27;

        System.out.println("After 15 years, age of " +name + " will be " + (age+15));
    }
    @Test
    public void TC_02(){
        int a = 3;
        int b = 4;
        a = a+b;
        b = a - b;
        a = a -b;

        System.out.println("After swapping then a = " +a +", b = " +b);

    }
    @Test
    public void TC_03(){
        int a = 5;
        int b =4;
        boolean bValue;

        bValue = (a>b) ?true :false;

        System.out.println(bValue);
    }
    @Test
    public void TC_04(){
        int a = 3;
        int b = 4;
        boolean bValue;

        bValue = (a>b) ?true :false;

        System.out.println(bValue);
    }
}
