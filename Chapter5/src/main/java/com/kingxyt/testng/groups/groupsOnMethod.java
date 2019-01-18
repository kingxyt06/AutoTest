package com.kingxyt.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupsOnMethod {

    @Test(groups = "Server")
    public void MethodOnServer1(){
        System.out.println("服务端运行的方法111");
    }
    @Test(groups = "Server")
    public void MethodOnServer2(){
        System.out.println("服务端运行的方法222");
    }
    @BeforeGroups("Server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }
    @AfterGroups("Server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }
    @BeforeGroups("Client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }
    @AfterGroups("Client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组运行之后运行的方法");
    }
    @Test(groups = "Client")
    public void MethodOnClient1(){
        System.out.println("客户端运行的方法111");
    }
    @Test(groups = "Client")
    public void MethodOnClient2(){
        System.out.println("客户端运行的方法222");
    }

}
