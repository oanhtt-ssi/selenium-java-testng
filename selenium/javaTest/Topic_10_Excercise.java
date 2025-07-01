package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_10_Excercise {
    Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
        Topic_10_Excercise obj = new Topic_10_Excercise();
        //obj.TC_01();
        obj.TC_02();
    }
    @Test
    public void TC_01(){
        while (true){
            //System.out.print("Nhập vào tên trình duyệt: ");
            String browser = scanner.nextLine();
            if (browser.equalsIgnoreCase("IE")){
                System.out.print("Bỏ qua khi tên trình duyệt là IE");
                continue;
            }
            System.out.print(browser);
        }
    }
    @Test
    public void TC_02(){
        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();
        switch (month){
            case 1:
                System.out.print("JAN");
                break;
            case 2:
                System.out.print("FEB");
                break;
            case 3:
                System.out.print("MAR");
                break;
            case 4:
                System.out.print("APR");
                break;
            case 5:
                System.out.print("MAY");
                break;
            case 6:
                System.out.print("JUN");
                break;
            case 7:
                System.out.print("JUL");
                break;
            case 8:
                System.out.print("AUG");
                break;
            case 9:
                System.out.print("SEP");
                break;
            case 10:
                System.out.print("OCT");
                break;
            case 11:
                System.out.print("NOV");
                break;
            case 12:
                System.out.print("DEC");
                break;
            default:
                System.out.print("Tháng nhập vào không hợp lệ");
                break;

        }
    }
}
