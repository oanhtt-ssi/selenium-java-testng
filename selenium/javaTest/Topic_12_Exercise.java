package javaTest;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_12_Exercise {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Topic_12_Exercise obj = new Topic_12_Exercise();
        obj.TC_01();
        obj.TC_02();
        obj.TC_03();
        obj.TC_04();
    }
    @Test
    public void TC_01(){
        System.out.println("-----Bài 1-----");
        System.out.print("Nhập chuỗi: ");
        String chuoi = scanner.nextLine();
        int upper = 0;
        for (int i = 0; i<chuoi.length();i++){
            char kytu = chuoi.charAt(i);
            if (Character.isUpperCase(kytu) ){
                upper +=1;
            }
        }
        System.out.print("Số ký tự in hoa trong chuỗi trên là: " +upper);
        System.out.println();
    }
    @Test
    public void TC_02(){
        System.out.println();
        String chuoi = "Automation Testing 345 Tutorials Online 789";
        System.out.println("-----Bài 2-----");
        //2.1 - Đếm số ký tự a có trong chuỗi
        System.out.print("Cho chuỗi: " +chuoi);
        System.out.println();
        int dem_a = 0;
        for (int i = 0; i < chuoi.length(); i++){
            char kytu = chuoi.charAt(i);
            if (kytu == 'a' || kytu =='A'){
                dem_a +=1;
            }
        }
        System.out.print("2.1.Số ký tự a có trong chuỗi trên: " +dem_a);
        //2.2-Kiểm tra chuỗi có chứa từ "Testing" hay không
        System.out.println();
        System.out.print("2.2.Chuỗi có chứa từ Testing: ");
         if (chuoi.toLowerCase().contains("testing")){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
        //2.3- Kiểm tra chuỗi có bắt đầu bằng Automation không
        System.out.print("2.3.Chuỗi có bắt đầu bằng từ Automation: ");
        if (chuoi.toLowerCase().startsWith("automation")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        //2.4- Kiểm tra chuỗi có kết thúc bằng Online không
        System.out.print("2.4.Chuỗi có kết thúc bằng từ online: ");
        if (chuoi.toLowerCase().endsWith("online")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        //2.5- Lấy vị trí của từ Tutorials
        int index = chuoi.indexOf("Tutorials");
        System.out.print("2.5.Vị trí của từ Tutorials trong chuỗi: " +index);
        //2.6- Thay thế từ online = offline
        System.out.println();
        String chuoi1 = chuoi.replace("Online","Offline");
        System.out.println("2.6.Chuỗi sau khi đã thay thế Online bằng Offline: " +chuoi1);
        //2.7- Đếm số lượng ký tự là số
        int dem_so =0;
        for (int i =0; i<chuoi.length();i++){
            char kytu = chuoi.charAt(i);
            if (Character.isDigit(kytu)){
                dem_so +=1;
            }
        }
        System.out.println("2.7.Số ký tự là số có trong chuỗi: " +dem_so);
    }
    @Test
    public void TC_03(){
        //3- Đảo ngược chuỗi
        System.out.println();
        System.out.println("-----Bài 3-----");
        System.out.print("Nhập chuỗi: ");
        String chuoi = scanner.nextLine();
        String reversed = new StringBuilder(chuoi).reverse().toString();
        System.out.println("Chuỗi đảo ngược: " +reversed);
    }
    @Test
    public void TC_04(){
        //4- Nhập vào số điện thoại có 10 số - bắt đầu bằng 7|8|9
        System.out.println();
        System.out.println("-----Bài 4-----");
        System.out.print("Nhập sđt: ");
        String chuoi = scanner.nextLine();
        if (chuoi.matches("^[789]\\d{9}$")){
            System.out.println("Số điện thoại đúng định dạng");
        }else {
            System.out.println("Số điện thoại không đúng định dạng");
        }
    }

}
