package com.kingxyt.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
//    最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod测试方法执行之前运行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod测试方法执行之后运行");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass是在类执行之前执行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass是在类执行之后执行的");
    }
}
