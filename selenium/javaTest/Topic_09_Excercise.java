package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_09_Excercise {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Topic_09_Excercise obj = new Topic_09_Excercise();
        //obj.TC_01();
        //obj.TC_02();
        //obj.TC_03();
        //obj.TC_04();
        //obj.TC_05();
        obj.TC_06();
    }

    @Test
    public void TC_01(){
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        System.out.print("Các số chẵn từ " + n + " đến 100: ");
        while (n<=100){
            if (n%2==0){
                System.out.print(n + " ");
            }
            n++;
        }
    }
    @Test
    public void TC_02(){
       System.out.print("Nhập 2 số nguyên a, b: ");
       int a = scanner.nextInt();
       int b = scanner.nextInt();
       System.out.print("Các số từ " + a + " đến " +b + " đều chia hết cho cả 3 và 5: ");
       while (a <= b){
           if (a%3==0 & a%5==0){
               System.out.print(a + " ");
           }
           a++;
       }
    }
    @Test
    public void TC_03(){
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int i = 0;
        int sum =0;
        while (i<=n){
            if (i%2!=0){
                sum +=i;
            }
            i++;

        }
        System.out.print("Tổng các số lẻ từ 0 tới " + n + ": "+sum);
    }
    @Test
    public void TC_04(){
        System.out.print("Nhập 2 số nguyên a, b: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.print("Các số từ " + a + " đến " +b + " chia hết cho cả 3: ");
        do {
            if (a%3==0){
                System.out.print(a + " ");
            }
            a++;
        } while (a <= b);
    }
    @Test
    public void TC_05(){
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int i=1;
        long giaithua=1;
        do {
            giaithua *=i;
            i++;
        } while ( i <= n);
        System.out.print(n+"! = "+giaithua);
    }
    @Test
    public void TC_06(){
        int i =1;
        int sum =0;
        while (i<=10){
            if (i%2==0){
                sum +=i;
            }
            i++;
        }
        System.out.print("Tổng các số chẵn từ 1 đến 10: "+sum);
    }
}
