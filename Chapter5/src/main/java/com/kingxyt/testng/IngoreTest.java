package com.kingxyt.testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
//忽略测试
public class IngoreTest {
    @Test
    public void ignore1(){
        System.out.println("忽略测试1");
    }
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("忽略测试2");
    }
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("忽略测试3");
    }

}
