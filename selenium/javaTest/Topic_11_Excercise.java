package javaTest;

import org.testng.annotations.Test;

public class Topic_11_Excercise {
    String name;
    int age;
    double Score;


    public static void main(String[] args) {
    TC_01();
    TC_02();
    TC_03();
    TC_04();
    TC_05();
    TC_06();
    TC_07();
    }

    @Test
    public static void TC_01() {
        int[] arr = {2, 7, 6, 8, 9};
        int max = arr[0];
        System.out.print("B1.Cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Số lớn nhất trong dãy số là: " + max);
    }

    @Test
    public static  void TC_02() {
        int[] arr = {2, 7, 6, 8, 9};
        int n = arr.length;
        System.out.print("B2.Cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Tổng phần từ đầu tiên và cuối cùng của mảng là: " + (arr[0] + arr[n - 1]));
    }

    @Test
    public static void TC_03() {
        int[] arr = {2, 7, 6, 8, 9, 16, 17, 20};
        System.out.print("B3.Cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("Những số chẵn trong mảng: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    @Test
    public static void TC_04() {
        int[] arr = {3, -7, 2, 5, 9, -6, 10, 12};
        int sum = 0;
        System.out.print("B4.Cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("Tồng các số lẻ trong mảng: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] > 0) {
                sum += arr[i];
            }
        }
        System.out.print(sum);
        System.out.println();
    }

    @Test
    public static void TC_05() {
        int[] arr = {3, -7, 2, 5, 9, -6, 10, 12};
        int sum = 0;
        System.out.print("B5.Cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("Các số >= 0 và <= 10 trong mảng: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 10) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    @Test
    public static void TC_06() {
        int[] arr = {3, 5, 7, 30, 10, 5, 9, 23, 9, -5};
        int sum = 0;
        System.out.print("B6.Cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("Tổng các số trong mảng: ");
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        float avg = (float) sum / arr.length;
        System.out.println("Trung bình cộng các giá trị phần từ trong mảng: " + avg);
    }


        public Topic_11_Excercise(String name, int age, double Score){
            this.name = name;
            this.age = age;
            this.Score = Score;

        }
        public void display(){

        System.out.println("Name: " +name);
        System.out.println("Age: " +age);
        System.out.println("Score: " +Score);
        }
        @Test
        public static void TC_07(){
        System.out.println("B7.Student Information: ");
        Topic_11_Excercise[] students = new Topic_11_Excercise[3];
        students[0] = new Topic_11_Excercise("Hoa",20,7.8);
        students[1] = new Topic_11_Excercise("Minh", 21, 8);
        students[2] = new Topic_11_Excercise("Hà",20,5.4);
        for (int i = 0; i <students.length; i++){
            students[i].display();
        }
        }


    }




