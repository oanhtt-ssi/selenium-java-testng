package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Exercise {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Topic_07_Exercise obj = new Topic_07_Exercise();
        //obj.TC_01();
        obj.TC_02();
        //obj.TC_03();
    }
    @Test
    public void TC_01(){
        System.out.println("Nhập số: ");
        int number = scanner.nextInt();
        switch (number){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println("Không show");
                break;
        }
    }
    @Test
    public void TC_02(){
        System.out.println("Nhập 2 số A,B: ");
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        String operator = scanner.next();
        switch (operator){
            case "+":
                System.out.println("A + B = " +(numberA+numberB));
                break;
            case "-":
                System.out.println("A - B = " +(numberA-numberB));
                break;
            case "*":
                System.out.println("A*B = " +(numberA*numberB));
                break;
            case "/":
                System.out.println("A/B = " +(numberA/numberB));
                break;
            case "%":
                System.out.println("A%B = " +(numberA%numberB));
                break;


        }
    }
    @Test
    public void TC_03(){
        System.out.println("Nhập tháng: ");
        int month = scanner.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " +month +" có 31 ngày");
                break;
            case 2:
                System.out.println("Tháng " +month +" có 28 hoặc 29 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " +month +" có 30 ngày");
                break;
            default:
                System.out.println("Tháng nhập vào không hợp lệ. Vui lòng nhập đúng!");
                break;
        }

    }
}
