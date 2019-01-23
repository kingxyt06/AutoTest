package com.kingxyt.testng.TestParameterXML;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestParameterDataProvider {
    @Test(dataProvider = "provideNum")
    public void test(int num , int except){

        Assert.assertEquals(num+10, except);
    }

    @DataProvider(name = "provideNum")
    public Object[][] provideData(){
        return new Object[][]{{10,20},{100,110},{200,210}};
    }

    @Test(dataProvider="data")
    public void test1(String name,int age){
        System.out.println("test111 name:"+name+"  age:"+age);
    }
    @Test(dataProvider ="data")
    public void test2(String name,int age){
        System.out.println("test222 name:"+name+"  age:"+age);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvide(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"john",20},
                    {"mike",18}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"amy",20},
                    {"lisa",18}
            };
        }
        return result;
    }
}
