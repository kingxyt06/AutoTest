package com.kingxyt.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupsOnClass3 {

    public void teacher1(){
        System.out.println("teacher11111");
    }
    public void teacher2(){
        System.out.println("teacher22222");
    }
}
