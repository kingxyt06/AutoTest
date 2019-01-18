package com.kingxyt.testng;

import org.testng.annotations.Test;

public class ExceptedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void ExceptionFail(){
        System.out.println("这是一个失败的异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void ExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void ExceptionSuccess2(){
        int a = 0;
        int b = 10;
        System.out.println(b/a);
    }
}
