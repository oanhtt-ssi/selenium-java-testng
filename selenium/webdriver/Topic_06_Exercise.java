package webdriver;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_Exercise {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Topic_06_Exercise obj = new Topic_06_Exercise();
        //obj.TC_01();
        //obj.TC_02();
        //obj.TC_03();
        //obj.TC_04();
        //obj.TC_05();
        //obj.TC_06();
        obj.TC_07();
    }

    @Test
    public void TC_01() {
        System.out.println("Bài 1: ");
        System.out.println("Nhập 1 số: ");
        int number = scanner.nextInt();
        //int number = 15;
        String check = (number % 2 == 0) ? "Số " + number + " là số chẵn" : "Số " + number + " là số lẻ";
        System.out.println(check);
    }

    @Test
    public void TC_02() {
        System.out.println("Bài 2: ");
        System.out.println("Nhập số A: ");
        int numberA = scanner.nextInt();
        System.out.println("Nhập số B: ");
        int numberB = scanner.nextInt();
        String compareNumber = (numberA >= numberB) ? (numberA + " lớn hơn hoặc bằng " + numberB) : (numberA + " nhỏ hơn " + numberB);
        System.out.println(compareNumber);
    }

    @Test
    public void TC_03() {
        System.out.println("Bài 3: ");
        System.out.println("Nhập tên SV thứ 1: ");
        String firstStudent = scanner.nextLine();
        System.out.println("Nhập tên SV thứ 2: ");
        String secondStudent = scanner.nextLine();
        String compareName = (firstStudent.equals(secondStudent)) ? "Hai SV có tên trùng nhau" : "Hai SV có tên khác nhau";
        System.out.println(compareName);

        if (firstStudent.equalsIgnoreCase(secondStudent)) {
            System.out.println("Hai SV có tên trùng nhau");
        } else {
            System.out.println("Hai SV có tên khác nhau");
        }
    }
    public void TC_04() {
        System.out.println("Nhập 3 số nguyên: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        if (number1 > number2 && number1 > number3) {
            System.out.println("Số lớn nhất trong 3 số là: " + number1);
        } else if (number2 > number3) {
            System.out.println("Số lớn nhất trong 3 số là: " + number2);
        } else {
            System.out.println("Số lớn nhất trong 3 số là: " + number3);
        }
    }
    public void TC_05(){
    System.out.println("Nhập số nguyên: ");
    int a = scanner.nextInt();
    if (a >= 10 && a <= 100){
        System.out.println(a + " nằm trong đoạn [10,100]");
    }
    else {
        System.out.println(a + " nằm ngoài đoạn [10,100]");
    }
}
    public void TC_06(){
        System.out.println("Nhập điểm hệ số: ");
       float studentPoint = scanner.nextFloat();
       if (studentPoint >=8.5 && studentPoint <=10){
           System.out.println("Điểm A");
       } else if (studentPoint < 8.5 && studentPoint >= 7.5){
           System.out.println("Điểm B");
       } else if (studentPoint < 7.5 && studentPoint >= 5) {
           System.out.println("Điểm C");
       } else if (studentPoint < 5 && studentPoint >= 0) {
           System.out.println("Điểm D");
       } else {
           System.out.println("Điểm nhập vào không hợp lệ. Vui lòng nhập điểm khác!");
       }
    }
    public void TC_07(){
        System.out.println("Nhập tháng: ");
        int month = scanner.nextInt();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            System.out.println("Tháng " +month + " có 31 ngày");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Tháng " +month + " có 30 ngày");
        } else if (month == 2) {
            System.out.println("Tháng " +month +" có 28 hoặc 29 ngày");
        }else {
            System.out.println("Tháng không hợp lệ. Vui lòng nhập lại thông tin tháng!");
        }
    }
}







