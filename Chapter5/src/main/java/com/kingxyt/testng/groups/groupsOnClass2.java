package com.kingxyt.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class groupsOnClass2 {

    public void stu1(){
        System.out.println("class2的stu11111");
    }
    public void stu2(){
        System.out.println("class2的stu22222");
    }
}
