package com.kingxyt.testng.dependsOnGroups;

import org.testng.annotations.Test;

public class TestApp {
    @Test(dependsOnGroups = {"Server","DB"})
    public void method1(){
        System.out.println("method1运行了");
    }
    @Test(dependsOnMethods = "method1")
    public void method2(){
        System.out.println("method2运行了");
    }
}
