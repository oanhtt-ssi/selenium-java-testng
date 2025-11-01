package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {

    @Test
    public void TC_01(){
        //Mong đợi điều kiện trả về là đúng
        Assert.assertTrue(3<5);
        Assert.assertTrue(3<5, "3 không nhỏ hơn 5");

        //Mong đợi điều kiện trả về là sai
        Assert.assertFalse(3>5);
        Assert.assertFalse(3>5,"3 nhỏ hơn 5");

        //Mong đợi 2 điều kiện bằng nhau
        //Actual - Expected
        Assert.assertEquals("An","Nan");
    }
}
