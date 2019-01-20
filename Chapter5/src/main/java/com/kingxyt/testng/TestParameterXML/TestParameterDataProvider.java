package com.kingxyt.testng.TestParameterXML;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterDataProvider {
    @Test(dataProvider = "provideNum")
    public void test(int num , int except){

        Assert.assertEquals(num+10, except);
    }

    @DataProvider(name = "provideNum")
    public Object[][] provideData(){
        return new Object[][]{{10,20},{100,110},{200,210}};
    }
}
