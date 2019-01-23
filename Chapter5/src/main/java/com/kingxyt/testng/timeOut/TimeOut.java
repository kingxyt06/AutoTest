package com.kingxyt.testng.timeOut;

import org.testng.annotations.Test;

public class TimeOut {

    @Test(timeOut = 3000)
    public void test(){
        try {
            Thread.sleep(2000);
            System.out.println("没超时");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(timeOut = 2000)
    public void test2(){
        try {
            Thread.sleep(3000);
            System.out.println("超时了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
