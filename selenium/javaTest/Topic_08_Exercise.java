package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_08_Exercise {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Topic_08_Exercise obj = new Topic_08_Exercise();
        //obj.TC_01();
        //obj.TC_02();
        //obj.TC_03();
        //obj.TC_04();
        //obj.TC_05();
        //obj.TC_06();
        obj.TC_07();

    }
    @Test
    public void TC_01(){
        System.out.println("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        for (int i = 1; i <=n; i++){
            System.out.print(i + " ");
        }
    }
    @Test
    public void TC_02(){
        System.out.println("Nhập số nguyên a, b: ");
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        for (int i = numberA; i <= numberB; i++){
            System.out.print(i + " ");
        }

    }
    @Test
    public void TC_03(){
        int sum = 0;
        for (int i=1; i<=10; i++){
            if (i%2 == 0){
                sum +=i;
            }
        }
        System.out.print(sum);
    }
    @Test
    public void TC_04(){
        int sum = 0;
        System.out.print("Nhập 2 số nguyên a, b: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i <=b; i++){
            sum +=i;
        }
        System.out.print(sum);
    }
    @Test
    public void TC_05(){
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <=n; i++){
            if (i%2 !=0){
                sum +=i;
            }
        }
        System.out.print(sum);
    }
    @Test
    public void TC_06(){
        System.out.print("Nhập số nguyên a,b: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i<=b; i++){
            if (i%3 ==0){
                System.out.print(i + " ");
            }
        }
    }
    @Test
    public void TC_07(){
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        long giaithua = 1;
        for (int i =1; i <=n; i++){
            giaithua *=i;
        }
        System.out.print("Giai thừa của số n = " + giaithua);
    }
}
