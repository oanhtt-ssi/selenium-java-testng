package testng;

import org.testng.Assert;

public class Topic_01_Assert {
    public static void main(String[] args) {
        //Kiểm tra dữ liệu đúng
        Assert.assertTrue(5>3);
        //Kiểm tra dữ liệu sai
        Assert.assertFalse(false);
        //Kiểm tra dữ liệu trả về có đúng với thực tế mong đợi
        Assert.assertEquals("Manual","Auto" );

    }
}
