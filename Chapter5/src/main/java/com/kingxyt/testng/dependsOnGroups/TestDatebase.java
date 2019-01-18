package com.kingxyt.testng.dependsOnGroups;

import org.testng.annotations.Test;

public class TestDatebase {
    @Test(groups = "DB",dependsOnGroups = "Server")
    public void initDB(){
        System.out.println("InitDB...");
    }
    @Test(groups = "DB",dependsOnMethods = {"initDB"})
    public void testConnection(){
        System.out.println("DB connect Successful");
    }
}
